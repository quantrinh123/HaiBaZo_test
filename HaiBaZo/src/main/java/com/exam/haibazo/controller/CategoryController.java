package com.exam.haibazo.controller;

import com.exam.haibazo.dto.ApiResponse;
import com.exam.haibazo.dto.CategoryDTO;
import com.exam.haibazo.service.ICategoryService;
import com.exam.haibazo.util.JsonResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryController {
    ICategoryService categoryService;
    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryDTO>>> getAll() {
        List<CategoryDTO> categories = categoryService.findAll();
        return JsonResponse.ok(categories);
    }

}
