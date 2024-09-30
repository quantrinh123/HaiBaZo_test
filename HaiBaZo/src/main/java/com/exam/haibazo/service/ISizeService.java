package com.exam.haibazo.service;

import com.exam.haibazo.dto.SizeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISizeService {
    List<SizeDTO> getAll();
}
