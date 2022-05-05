package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class File
{
    private Long id;
    private String filename;
    private String fileExt;
    private String url;
    private Long fileSize;
    private String originalFilename;
    private String mimeType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public File(
            @JsonProperty("id") Long id,
            @JsonProperty("filename") String filename,
            @JsonProperty("extension") String fileExt,
            @JsonProperty("url") String url,
            @JsonProperty("size") Long fileSize,
            @JsonProperty("original_filename") String originalFilename,
            @JsonProperty("mime_type") String mimeType,
            @JsonProperty("created_at") LocalDateTime createdAt,
            @JsonProperty("updated_at") LocalDateTime updatedAt)
    {
        this.id = id;
        this.filename = filename;
        this.fileExt = fileExt;
        this.url = url;
        this.fileSize = fileSize;
        this.originalFilename = originalFilename;
        this.mimeType = mimeType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
