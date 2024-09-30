package com.exam.haibazo.service.impl;

import com.exam.haibazo.dto.CategoryDTO;
import com.exam.haibazo.mapper.CategoryMapper;
import com.exam.haibazo.model.Category;
import com.exam.haibazo.repository.CategoryRepository;
import com.exam.haibazo.service.ICategoryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class CategoryService implements ICategoryService {
    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;
    @Override
    public List<CategoryDTO> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(categoryMapper::toCategoryDTO)
                .collect(Collectors.toList());
    }
}
