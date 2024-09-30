package com.exam.haibazo.mapper;

import com.exam.haibazo.dto.StyleDTO;
import com.exam.haibazo.model.Style;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StyleMapper {
    @Mapping(target = "styleId", source = "styleId")
    @Mapping(target = "name", source = "name")
    StyleDTO toStyleDTO(Style style);
    @Mapping(target = "styleId", source = "styleId")
    @Mapping(target = "name", source = "name")
    Style toStyleEntity(StyleDTO styleDTO);
}

