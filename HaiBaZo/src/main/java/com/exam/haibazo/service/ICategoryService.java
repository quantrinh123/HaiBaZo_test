package com.exam.haibazo.service;

import com.exam.haibazo.dto.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    List<CategoryDTO> findAll();
}
