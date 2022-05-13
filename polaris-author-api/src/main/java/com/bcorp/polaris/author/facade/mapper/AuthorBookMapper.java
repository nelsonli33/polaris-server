package com.bcorp.polaris.author.facade.mapper;

import com.bcorp.polaris.author.dto.UpdateBookDto;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = FacadeMapperConfig.class)
public interface AuthorBookMapper
{
    void update(UpdateBookDto updateBookDto, @MappingTarget BookRecord bookRecord);
}
