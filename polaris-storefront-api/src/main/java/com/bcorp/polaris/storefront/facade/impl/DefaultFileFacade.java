package com.bcorp.polaris.storefront.facade.impl;

import com.bcorp.polaris.core.dto.FileDto;
import com.bcorp.polaris.core.model.tables.records.FileRecord;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.core.service.impl.GCSStorageService;
import com.bcorp.polaris.storefront.dao.service.UserService;
import com.bcorp.polaris.storefront.facade.FileFacade;
import com.bcorp.polaris.storefront.facade.converter.DtoConverter;
import com.google.cloud.storage.Blob;
import org.apache.commons.io.FilenameUtils;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import static com.bcorp.polaris.core.model.tables.File.FILE;

@Component(value = "fileFacade")
public class DefaultFileFacade implements FileFacade
{
    private GCSStorageService gcsStorageService;
    private UserService userService;
    private DSLContext dslContext;
    private DtoConverter dtoConverter;


    @Autowired
    public DefaultFileFacade(GCSStorageService gcsStorageService,
                             UserService userService,
                             DSLContext dslContext,
                             DtoConverter dtoConverter)
    {
        this.gcsStorageService = gcsStorageService;
        this.userService = userService;
        this.dslContext = dslContext;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public FileDto upload(MultipartFile file)
    {
        final UserRecord currentUser = userService.getCurrentUser();

        final Blob blob = gcsStorageService.upload(file);

        final FileRecord fileRecord = dslContext.newRecord(FILE);
        fileRecord.setName(blob.getName());
        fileRecord.setExtension(FilenameUtils.getExtension(file.getOriginalFilename()));
        fileRecord.setUrl("https://storage.googleapis.com/" + blob.getBucket() + "/" + blob.getName());
        fileRecord.setFileSize(blob.getSize());
        fileRecord.setOriginalFilename(file.getOriginalFilename());
        fileRecord.setMimeType(blob.getContentType());
        fileRecord.setUserId(currentUser.getId());
        fileRecord.store();
        fileRecord.refresh();

        return dtoConverter.convert(fileRecord);
    }
}
