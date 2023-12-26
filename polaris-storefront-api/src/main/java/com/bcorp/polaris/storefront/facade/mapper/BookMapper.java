package com.bcorp.polaris.storefront.facade.mapper;

import com.bcorp.polaris.core.dto.BookDto;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import org.mapstruct.Mapper;

import java.util.Arrays;
import java.util.List;

@Mapper(config = FacadeMapperConfig.class)
public interface BookMapper
{
    BookDto toDto(BookRecord bookRecord);

    List<BookDto> toDtos(List<BookRecord> bookRecords);

    default List<String> split(String str)
    {
        return Arrays.asList(str.split(","));
    }

    default String join(List<String> str)
    {
        return String.join(",", str);
    }
}
