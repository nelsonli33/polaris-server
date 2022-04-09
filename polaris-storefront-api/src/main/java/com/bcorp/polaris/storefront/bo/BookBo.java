package com.bcorp.polaris.storefront.bo;

import com.bcorp.polaris.core.model.tables.records.BookRecord;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookBo
{
    private String title;
    private BigDecimal price;
    private String key;
    private Long bookId;
    private BookRecord book;
}
