package com.bcorp.polaris.storefront.controller;


import com.bcorp.polaris.core.dto.FileDto;
import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.storefront.api.model.UploadFileResponse;
import com.bcorp.polaris.storefront.facade.FileFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController extends AbstractController
{
    private FileFacade fileFacade;

    @Autowired
    public FileUploadController(FileFacade fileFacade)
    {
        this.fileFacade = fileFacade;
    }

    @PostMapping("/api/v1/upload")
    public ResponseEntity<UploadFileResponse> upload(@RequestParam("file") MultipartFile file)
    {
        if (file.isEmpty())
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.UPLOAD_ERROR, "Failed to upload empty file.");
        }

        final FileDto fileDto = fileFacade.upload(file);

        UploadFileResponse response = UploadFileResponse.builder()
                .file(getStorefrontRestMapper().convert(fileDto))
                .build();
        return ResponseEntity.ok(response);
    }
}
