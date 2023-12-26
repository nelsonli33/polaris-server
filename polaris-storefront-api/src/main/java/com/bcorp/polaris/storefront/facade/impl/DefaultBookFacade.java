package com.bcorp.polaris.storefront.facade.impl;

import com.bcorp.polaris.core.dto.BookDto;
import com.bcorp.polaris.core.dto.ChapterDto;
import com.bcorp.polaris.core.dto.PageDto;
import com.bcorp.polaris.core.dto.TableOfContentDto;
import com.bcorp.polaris.core.model.tables.records.BookCategoryRecord;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;
import com.bcorp.polaris.storefront.bo.BookBo;
import com.bcorp.polaris.storefront.dao.service.BookCategoryService;
import com.bcorp.polaris.storefront.dao.service.BookService;
import com.bcorp.polaris.storefront.facade.BookFacade;
import com.bcorp.polaris.storefront.facade.mapper.BookCategoryMapper;
import com.bcorp.polaris.storefront.facade.mapper.BookMapper;
import com.bcorp.polaris.storefront.facade.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component(value = "bookFacade")
public class DefaultBookFacade implements BookFacade
{
    private BookService bookService;
    private BookCategoryService bookCategoryService;
    private BookMapper bookMapper;

    private BookCategoryMapper bookCategoryMapper;
    private UserMapper userMapper;


    public DefaultBookFacade(
            BookService bookService,
            BookCategoryService bookCategoryService,
            BookMapper bookMapper,
            BookCategoryMapper bookCategoryMapper,
            UserMapper userMapper
    )
    {
        this.bookMapper = bookMapper;
        this.bookCategoryService = bookCategoryService;
        this.userMapper = userMapper;
        this.bookService = bookService;
        this.bookCategoryMapper = bookCategoryMapper;
    }

    @Override
    public List<BookDto> getAllBooks()
    {
        final List<BookRecord> allBooks = bookService.getAllBooks();
        return bookMapper.toDtos(allBooks);
    }

    @Override
    public BookDto getBookDetail(Long bookId)
    {
        final BookBo bookBo = bookService.getBookAndAuthorForId(bookId);
        final TableOfContentDto tableOfContentDto = getTableOfContent(bookId);

        final List<BookCategoryRecord> bookCategories
                = bookCategoryService.getBookCategoriesForBook(bookBo.getBook());

        final BookDto bookDto = bookMapper.toDto(bookBo.getBook());
        bookDto.setAuthor(userMapper.toDto(bookBo.getAuthor()));
        bookDto.setCategories(bookCategoryMapper.toDtos(bookCategories));
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
