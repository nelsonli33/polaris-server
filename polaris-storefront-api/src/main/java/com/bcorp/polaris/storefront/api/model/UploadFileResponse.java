package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UploadFileResponse
{
    private File file;

    public UploadFileResponse(
            @JsonProperty("file") File file)
    {
        this.file = file;
    }
}
