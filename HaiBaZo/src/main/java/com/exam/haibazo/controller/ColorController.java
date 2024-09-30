package com.exam.haibazo.controller;

import com.exam.haibazo.dto.ApiResponse;
import com.exam.haibazo.dto.ColorDTO;
import com.exam.haibazo.service.IColorService;
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
@RequestMapping("/api/colors")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ColorController {
    IColorService colorService;
    @GetMapping
    public ResponseEntity<ApiResponse<List<ColorDTO>>> getAll() {
        List<ColorDTO> colorDTOS = colorService.findAll();
        return JsonResponse.ok(colorDTOS);
    }
}
