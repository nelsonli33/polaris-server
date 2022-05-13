package com.bcorp.polaris.author.controller;

import com.bcorp.polaris.author.controller.mapper.AuthorRestMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractAuthorController
{
    private AuthorRestMapper authorRestMapper;

    public AuthorRestMapper getAuthorRestMapper()
    {
        return authorRestMapper;
    }

    @Autowired
    public void setAuthorRestMapper(AuthorRestMapper authorRestMapper)
    {
        this.authorRestMapper = authorRestMapper;
    }
}
