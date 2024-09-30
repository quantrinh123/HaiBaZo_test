package com.exam.haibazo.service.impl;

import com.exam.haibazo.dto.ColorDTO;
import com.exam.haibazo.mapper.ColorMapper;
import com.exam.haibazo.model.Color;
import com.exam.haibazo.repository.ColorRepository;
import com.exam.haibazo.service.IColorService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ColorService implements IColorService {
    ColorRepository colorRepository;
ColorMapper colorMapper;
    @Override
    public List<ColorDTO> findAll() {
        List<Color> colors = colorRepository.findAll();
        return colors.stream().map(colorMapper::toDTO)
                .collect(Collectors.toList());
    }

}
