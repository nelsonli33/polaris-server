package com.bcorp.polaris.author.facade.mapper;

import com.bcorp.polaris.core.dto.ChapterDto;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import org.mapstruct.Mapper;

@Mapper(config = FacadeMapperConfig.class)
public interface AuthorChapterMapper
{
    ChapterDto toDto(ChapterRecord chapterRecord);
}
