package com.bcorp.polaris.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileDto
{
    private Long id;
    private Long userId;
    private String filename;
    private String fileExt;
    private String url;
    private Long fileSize;
    private String originalFilename;
    private String mimeType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
