package com.bcorp.polaris.storefront.facade.impl;

import com.bcorp.polaris.core.dto.*;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;
import com.bcorp.polaris.storefront.facade.BookFacade;
import com.bcorp.polaris.storefront.service.BookService;
import org.jooq.Record;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component(value = "bookFacade")
public class DefaultBookFacade implements BookFacade
{
    private BookService bookService;

    public DefaultBookFacade(BookService bookService)
    {
        this.bookService = bookService;
    }

    @Override
    public BookDto getBookIntro(Long bookId)
    {
        final Record record = bookService.getBookAndAuthorForId(bookId);
        final TableOfContentDto tableOfContentDto = getTableOfContent(bookId);

        final BookDto bookDto = record.into(BookDto.class);
        bookDto.setAuthor(record.into(UserDto.class));
        bookDto.setTableOfContent(tableOfContentDto);
        return bookDto;
    }

    private TableOfContentDto getTableOfContent(Long bookId)
    {
        final Map<ChapterRecord, List<PageRecord>> tableOfContent
                = bookService.getTableOfContent(bookId);

        List<ChapterDto> allChapterDtos = tableOfContent.entrySet().stream().map(e -> {
            ChapterDto chapterDto = e.getKey().into(ChapterDto.class);
            final List<PageDto> pageDtos
                    = e.getValue().stream().map(p -> p.into(PageDto.class)).collect(Collectors.toList());
            chapterDto.setPages(pageDtos);
            return chapterDto;
        }).collect(Collectors.toList());

        TableOfContentDto dto = new TableOfContentDto();
        dto.setChapters(allChapterDtos);
        return dto;
    }
}
