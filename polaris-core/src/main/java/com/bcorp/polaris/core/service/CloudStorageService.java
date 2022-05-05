package com.bcorp.polaris.core.service;

import com.google.cloud.storage.Blob;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CloudStorageService
{
    Blob upload(MultipartFile file);

    void deleteObjects(List<String> objectNames);
}
