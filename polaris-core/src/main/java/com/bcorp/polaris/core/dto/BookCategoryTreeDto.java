/*
 * This file is generated by jOOQ.
 */
package com.bcorp.polaris.core.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookCategoryTreeDto
{
    private Long id;
    private String name;
    private Long parentId;
    private List<BookCategoryTreeDto> children;
}