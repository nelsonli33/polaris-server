package com.bcorp.polaris.author.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageDto
{
    private Long id;
    private Long bookId;
    private Long chapterId;
    private Long authorId;
    private String title;
    private String body;
    private Integer characterCount;
    private Integer sortPosition;
    private Byte isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
