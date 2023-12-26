package com.bcorp.polaris.author.facade.mapper;

import com.bcorp.polaris.author.dto.UpdateBookDto;
import com.bcorp.polaris.core.dto.BookDto;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Arrays;
import java.util.List;

@Mapper(config = FacadeMapperConfig.class)
public interface AuthorBookMapper
{
    BookDto toDto(BookRecord bookRecord);

    List<BookDto> toDtos(List<BookRecord> bookRecords);

    void update(UpdateBookDto updateBookDto, @MappingTarget BookRecord bookRecord);


    default List<String> split(String str)
    {
        return Arrays.asList(str.split(","));
    }

    default String join(List<String> str)
    {
        return String.join(",", str);
    }
}
