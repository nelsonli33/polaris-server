package com.bcorp.polaris.author.controller.mapper;

import com.bcorp.polaris.author.dto.BookDto;
import com.bcorp.polaris.author.dto.ChapterDto;
import com.bcorp.polaris.author.dto.PageDto;
import com.bcorp.polaris.author.dto.TableOfContentDto;
import com.bcorp.polaris.author.model.Book;
import com.bcorp.polaris.author.model.Chapter;
import com.bcorp.polaris.author.model.Page;
import com.bcorp.polaris.author.model.TableOfContent;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface AuthorRestMapper
{
    Book convert(BookDto bookDto);

    Chapter convert(ChapterDto chapterDto);

    Page convert(PageDto pageDto);

    TableOfContent convert(TableOfContentDto tableOfContentDto);
}
