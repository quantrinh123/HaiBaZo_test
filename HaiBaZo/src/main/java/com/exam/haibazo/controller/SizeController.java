package com.exam.haibazo.controller;

import com.exam.haibazo.dto.ApiResponse;
import com.exam.haibazo.dto.SizeDTO;
import com.exam.haibazo.service.ISizeService;
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
@RequestMapping("/api/sizes")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SizeController {
    ISizeService sizeService;
    @GetMapping
    public ResponseEntity<ApiResponse<List<SizeDTO>>> getAll(){
        List<SizeDTO> sizeDTOS = sizeService.getAll();
        return JsonResponse.ok(sizeDTOS);
    }
}
