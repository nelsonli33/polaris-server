package com.bcorp.polaris.author.controller.mapper;

import com.bcorp.polaris.author.api.model.Book;
import com.bcorp.polaris.author.api.model.*;
import com.bcorp.polaris.author.dto.UpdateBookDto;
import com.bcorp.polaris.core.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface AuthorRestMapper
{
    Book convert(BookDto bookDto);

    List<Book> convertList(List<BookDto> bookDtos);

    BookCategory convert(BookCategoryDto bookCategoryDto);

    Chapter convert(ChapterDto chapterDto);

    Page convert(PageDto pageDto);

    TableOfContent convert(TableOfContentDto tableOfContentDto);

    List<CategoryTree> convert(List<BookCategoryTreeDto> bookCategoryTreeDto);

    UpdateBookDto toDto(UpdateBookRequest body);
}
