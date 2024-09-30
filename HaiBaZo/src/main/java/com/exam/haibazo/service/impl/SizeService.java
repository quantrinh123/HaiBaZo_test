package com.exam.haibazo.service.impl;

import com.exam.haibazo.dto.SizeDTO;
import com.exam.haibazo.exception.ApiException;
import com.exam.haibazo.exception.ErrorCode;
import com.exam.haibazo.mapper.SizeMapper;
import com.exam.haibazo.model.Size;
import com.exam.haibazo.repository.SizeRepository;
import com.exam.haibazo.service.ISizeService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SizeService implements ISizeService {
    SizeRepository sizeRepository;
    SizeMapper sizeMapper;
    public List<SizeDTO> getAll() {
        List<Size> sizes = sizeRepository.findAll();
        if (sizes.isEmpty()) {
            throw new ApiException(ErrorCode.Sizes_NOT_EXIST);
        }
        return sizes.stream().map(sizeMapper::toSizeDTO)
                .collect(Collectors.toList());
    }
}
