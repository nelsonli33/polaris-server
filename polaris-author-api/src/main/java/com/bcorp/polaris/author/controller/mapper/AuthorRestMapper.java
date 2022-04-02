package com.bcorp.polaris.author.controller.mapper;

import com.bcorp.polaris.author.dto.BookDto;
import com.bcorp.polaris.author.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface AuthorRestMapper
{
    Book convert(BookDto bookDto);
}
