package com.exam.haibazo.controller;

import com.exam.haibazo.dto.ApiResponse;
import com.exam.haibazo.dto.StyleDTO;
import com.exam.haibazo.service.IStyleService;
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
@RequestMapping("/api/styles")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StyleController {
    IStyleService styleService;
    @GetMapping
    public ResponseEntity<ApiResponse<List<StyleDTO>>> getAll() {
        List<StyleDTO> styleDTOS = styleService.findAll();
        return JsonResponse.ok(styleDTOS);
    }
}