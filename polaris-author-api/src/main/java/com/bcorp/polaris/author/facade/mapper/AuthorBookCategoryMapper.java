package com.bcorp.polaris.author.facade.mapper;

import com.bcorp.polaris.core.dto.BookCategoryDto;
import com.bcorp.polaris.core.model.tables.records.BookCategoryRecord;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = FacadeMapperConfig.class)
public interface AuthorBookCategoryMapper
{
    List<BookCategoryDto> toDto(List<BookCategoryRecord> bookCategoryRecords);
}
