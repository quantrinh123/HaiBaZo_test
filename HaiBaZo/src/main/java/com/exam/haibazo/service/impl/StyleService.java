package com.exam.haibazo.service.impl;

import com.exam.haibazo.dto.StyleDTO;
import com.exam.haibazo.mapper.StyleMapper;
import com.exam.haibazo.model.Style;
import com.exam.haibazo.repository.StyleRepository;
import com.exam.haibazo.service.IStyleService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StyleService implements IStyleService {
    StyleRepository styleRepository;
    StyleMapper styleMapper;

    @Override
    public List<StyleDTO> findAll() {
        List<Style> styles = styleRepository.findAll();
        return styles.stream().map(styleMapper::toStyleDTO)
                .collect(Collectors.toList());
    }
}
