package com.bcorp.polaris.author.facade.mapper;

import com.bcorp.polaris.core.dto.PageDto;
import com.bcorp.polaris.core.dto.SavePageDto;
import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.PageRecord;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jooq.JSON;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(config = FacadeMapperConfig.class)
public interface AuthorPageMapper
{
    @Mapping(target = "authorId", source = "userId")
    @Mapping(target = "body", source = "body", qualifiedByName = "toNormalJson")
    PageDto toDto(PageRecord pageRecord);

    @Mapping(target = "body", source = "body", qualifiedByName = "toJSON")
    void update(SavePageDto savePageDto, @MappingTarget PageRecord pageRecord);

    @Named("toJSON")
    default JSON toJSON(String jsonStr)
    {
        try
        {
            ObjectMapper objectMapper = new ObjectMapper();
            return JSON.json(objectMapper.writeValueAsString(jsonStr));
        }
        catch (JsonProcessingException e)
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.INTERNAL_SERVER_ERROR, "string convert to JSON type failed.", e);
        }
    }

    @Named("toNormalJson")
    default Object toNormalJson(JSON json)
    {
        if (json == null)
        {
            return null;
        }
        try
        {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json.data(), Object.class);
        }
        catch (JsonProcessingException e)
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.INTERNAL_SERVER_ERROR, "JSON convert to Map failed.", e);
        }
    }
}


