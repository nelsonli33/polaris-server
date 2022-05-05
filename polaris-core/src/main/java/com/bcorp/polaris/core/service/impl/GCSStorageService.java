package com.bcorp.polaris.core.service.impl;

import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.service.CloudStorageService;
import com.bcorp.polaris.core.service.KeyGenerator;
import com.google.cloud.BatchResult;
import com.google.cloud.storage.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service(value = "gcsStorageService")
public class GCSStorageService implements CloudStorageService
{
    @Value("${google.storage.bucket}")
    private String bucketName;
    private Storage storage;
    private KeyGenerator keyGenerator;

    public GCSStorageService(Storage storage,
                             @Qualifier(value = "uuidKeyGenerator") KeyGenerator keyGenerator)
    {
        this.storage = storage;
        this.keyGenerator = keyGenerator;
    }

    @Override
    public Blob upload(MultipartFile file)
    {
        String fileName = keyGenerator.generate() + "_" +
                file.getOriginalFilename();


        BlobId blobId = BlobId.of(bucketName, fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType(file.getContentType())
                .setAcl(new ArrayList<>(
                        List.of(Acl.of(Acl.User.ofAllUsers(),
                                Acl.Role.READER))))
                .build();
        try
        {
            Blob blob = storage.create(blobInfo, file.getBytes());
            log.info("{} successfully upload to gcs.", fileName);
            return blob;
        }
        catch (IOException | StorageException e)
        {
            log.info("{} failed upload to gcs. {}", fileName, e.getMessage());
            throw new PolarisServerRuntimeException(InternalErrorCode.UPLOAD_ERROR, fileName + " failed to upload.");
        }
    }

    @Override
    public void deleteObjects(List<String> objectNames)
    {
        final StorageBatch batch = storage.batch();

        List<BlobId> blobIds = new ArrayList<>();
        for (String objectName : objectNames)
        {
            if (StringUtils.isNotEmpty(objectName))
            {
                BlobId blobId = BlobId.of(bucketName, objectName);
                if (storage.get(blobId).exists())
                {
                    blobIds.add(blobId);
                }
            }
        }


        for (BlobId blobId : blobIds)
        {
            batch.delete(blobId).notify(new BatchResult.Callback<>()
            {
                @Override
                public void success(Boolean result)
                {
                    // delete successfully
                    log.info("Object {}  was deleted from {}", blobId, bucketName);
                }

                @Override
                public void error(StorageException e)
                {
                    throw e;
                }
            });
        }

        batch.submit();
    }
}
