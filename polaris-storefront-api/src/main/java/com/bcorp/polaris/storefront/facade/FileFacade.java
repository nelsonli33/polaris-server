package com.bcorp.polaris.storefront.facade;

import com.bcorp.polaris.core.dto.FileDto;
import org.springframework.web.multipart.MultipartFile;

public interface FileFacade
{
    FileDto upload(MultipartFile file);
}
