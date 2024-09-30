package com.exam.haibazo.service;

import com.exam.haibazo.dto.ColorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IColorService {
    List<ColorDTO> findAll();
}
