package com.bcorp.polaris.author.controller;

import com.bcorp.polaris.author.controller.mapper.AuthorRestMapper;
import com.bcorp.polaris.author.dto.ChapterDto;
import com.bcorp.polaris.author.dto.CreateChapterDto;
import com.bcorp.polaris.author.dto.UpdateChapterDto;
import com.bcorp.polaris.author.facade.AuthorChapterFacade;
import com.bcorp.polaris.author.model.CreateChapterRequest;
import com.bcorp.polaris.author.model.CreateChapterResponse;
import com.bcorp.polaris.author.model.UpdateChapterRequest;
import com.bcorp.polaris.author.model.UpdateChapterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AuthorChapterController
{
    private AuthorChapterFacade authorChapterFacade;
    private AuthorRestMapper authorRestMapper;

    @Autowired
    public AuthorChapterController(AuthorChapterFacade authorChapterFacade, AuthorRestMapper authorRestMapper)
    {
        this.authorChapterFacade = authorChapterFacade;
        this.authorRestMapper = authorRestMapper;
    }

    @PostMapping(path = "/author/api/v1/books/{book_id}/chapters")
    public ResponseEntity<CreateChapterResponse> createBookChapter(@Valid @RequestBody CreateChapterRequest body,
                                                                   @PathVariable(name = "book_id") Long bookId)
    {
        CreateChapterDto dto = new CreateChapterDto();
        dto.setBookId(bookId);
        dto.setTitle(body.getTitle());
        dto.setPreviousChapterId(body.getPreviousChapterId());
        final ChapterDto newChapterDto = authorChapterFacade.createNewChapter(dto);

        final CreateChapterResponse response = CreateChapterResponse.builder()
                .chapter(authorRestMapper.convert(newChapterDto))
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping(path = "/author/api/v1/books/{book_id}/chapters/{chapter_id}")
    public ResponseEntity<UpdateChapterResponse> updateBookChapter(@Valid @RequestBody UpdateChapterRequest body,
                                                                   @PathVariable(name = "book_id") Long bookId,
                                                                   @PathVariable(name = "chapter_id") Long chapterId)
    {
        UpdateChapterDto dto = new UpdateChapterDto();
        dto.setTitle(body.getTitle());
        dto.setBookId(bookId);
        dto.setChapterId(chapterId);
        final ChapterDto updatedChapterDto = authorChapterFacade.updateChapter(dto);

        final UpdateChapterResponse response = UpdateChapterResponse.builder()
                .chapter(authorRestMapper.convert(updatedChapterDto))
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

//    @DeleteMapping(path = "/author/api/v1/books/{book_id}/chapters/{chapter_id}")
//    public ResponseEntity<?> deleteBookChapter(@PathVariable(name = "book_id") Long bookId,
//                                               @PathVariable(name = "chapter_id") Long chapterId)
//    {
//        // cascade delete pages
//    }
}
