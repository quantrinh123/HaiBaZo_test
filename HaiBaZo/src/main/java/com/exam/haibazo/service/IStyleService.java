package com.exam.haibazo.service;

import com.exam.haibazo.dto.StyleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStyleService {
    List<StyleDTO> findAll();
}
