package com.exam.haibazo.mapper;

import com.exam.haibazo.dto.CategoryDTO;
import com.exam.haibazo.model.Category;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toCategoryDTO(Category category);
    Category toEntity(CategoryDTO categoryDTO);
}

