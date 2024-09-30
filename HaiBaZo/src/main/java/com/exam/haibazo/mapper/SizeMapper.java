package com.exam.haibazo.mapper;

import com.exam.haibazo.dto.SizeDTO;
import com.exam.haibazo.model.Size;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SizeMapper {
    

    Size toSizesEntity(SizeDTO sizeDTO);

    SizeDTO toSizeDTO(Size size);
}

