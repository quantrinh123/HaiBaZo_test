package com.exam.haibazo.mapper;

import com.exam.haibazo.dto.ColorDTO;
import com.exam.haibazo.model.Color;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ColorMapper {

    @Mapping(target = "colorId", source = "colorId")
    @Mapping(target = "name", source = "name")
    ColorDTO toDTO(Color color);

    @Mapping(target = "colorId", source = "colorId")
    @Mapping(target = "name", source = "name")
    Color toEntity(ColorDTO colorDTO);
}

