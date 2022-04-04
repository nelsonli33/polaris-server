package com.bcorp.polaris.author.facade.impl;

import com.bcorp.polaris.author.dto.BookDto;
import com.bcorp.polaris.author.dto.ChapterDto;
import com.bcorp.polaris.author.dto.PageDto;
import com.bcorp.polaris.author.dto.TableOfContentDto;
import com.bcorp.polaris.author.facade.AuthorBookFacade;
import com.bcorp.polaris.author.service.AuthorBookService;
import com.bcorp.polaris.author.service.AuthorChapterService;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component(value = "authorBookFacade")
public class DefaultAuthorBookFacade implements AuthorBookFacade
{
    private AuthorBookService authorBookService;
    private AuthorChapterService authorChapterService;


    @Autowired
    public DefaultAuthorBookFacade(
            AuthorBookService authorBookService,
            AuthorChapterService authorChapterService
    )
    {
        this.authorBookService = authorBookService;
        this.authorChapterService = authorChapterService;
    }

    @Override
    public BookDto getBookIntro(Long bookId)
    {
        final BookRecord bookRecord = authorBookService.getBookForId(bookId);
        final TableOfContentDto tableOfContentDto = getTableOfContent(bookRecord);

        final BookDto bookDto = bookRecord.into(BookDto.class);
        bookDto.setTableOfContent(tableOfContentDto);
        return bookDto;
    }

    @Override
    public BookDto createNewBook(String title)
    {
        final BookRecord newBook = authorBookService.createNewBook(title);
        return newBook.into(BookDto.class);
    }


    private TableOfContentDto getTableOfContent(BookRecord bookRecord)
    {
        final Map<Long, List<PageRecord>> tableOfContentMap
                = authorBookService.getTableOfContent(bookRecord);
        final List<ChapterRecord> allChapters
                = authorChapterService.getAllChaptersForBook(bookRecord);


        final List<ChapterDto> allChapterDtos = allChapters.stream().map(c -> {
            ChapterDto dto = c.into(ChapterDto.class);
            final List<PageDto> pages = tableOfContentMap.get(c.getId())
                    .stream().map(p -> p.into(PageDto.class))
                    .collect(Collectors.toList());
            dto.setPages(pages);
            return dto;
        }).collect(Collectors.toList());

        TableOfContentDto dto = new TableOfContentDto();
        dto.setChapters(allChapterDtos);
        return dto;
    }
}
