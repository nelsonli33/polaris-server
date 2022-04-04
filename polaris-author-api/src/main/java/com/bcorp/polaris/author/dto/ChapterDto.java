/*
 * This file is generated by jOOQ.
 */
package com.bcorp.polaris.author.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChapterDto
{
    private Long id;
    private Long bookId;
    private String title;
    private Integer sortPosition;
    private List<PageDto> pages;
    private Byte isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
