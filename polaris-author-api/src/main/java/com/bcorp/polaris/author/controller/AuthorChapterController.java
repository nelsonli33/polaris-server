package com.bcorp.polaris.author.controller;

import com.bcorp.polaris.author.api.model.CreateChapterRequest;
import com.bcorp.polaris.author.api.model.CreateChapterResponse;
import com.bcorp.polaris.author.api.model.UpdateChapterRequest;
import com.bcorp.polaris.author.api.model.UpdateChapterResponse;
import com.bcorp.polaris.author.facade.AuthorChapterFacade;
import com.bcorp.polaris.core.dto.ChapterDto;
import com.bcorp.polaris.core.dto.CreateChapterDto;
import com.bcorp.polaris.core.dto.UpdateChapterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AuthorChapterController extends AbstractAuthorController
{
    private AuthorChapterFacade authorChapterFacade;

    @Autowired
    public AuthorChapterController(AuthorChapterFacade authorChapterFacade)
    {
        this.authorChapterFacade = authorChapterFacade;
    }

    @PostMapping(path = "/author/api/v1/books/{book_id}/chapters")
    public ResponseEntity<CreateChapterResponse> createBookChapter(
            @PathVariable(name = "book_id") Long bookId,
            @RequestBody CreateChapterRequest body
    )
    {
        CreateChapterDto dto = new CreateChapterDto();
        dto.setBookId(bookId);
        dto.setTitle(body.getTitle());
        dto.setBelowChapterId(body.getBelowChapterId());
        final ChapterDto newChapterDto = authorChapterFacade.createNewChapter(dto);

        final CreateChapterResponse response = CreateChapterResponse.builder()
                .chapter(getAuthorRestMapper().convert(newChapterDto))
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
                .chapter(getAuthorRestMapper().convert(updatedChapterDto))
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
