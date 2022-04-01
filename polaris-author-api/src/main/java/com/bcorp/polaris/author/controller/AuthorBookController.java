package com.bcorp.polaris.author.controller;

import com.bcorp.polaris.author.model.CreateBookRequest;
import com.bcorp.polaris.author.model.CreateBookResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthorBookController
{
    @PostMapping(path = "/author/api/v1/books")
    public CreateBookResponse createBook(@Valid @RequestBody CreateBookRequest body)
    {
      
        return null;
    }
}
