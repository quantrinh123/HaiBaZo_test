package com.exam.haibazo.mapper;

import com.exam.haibazo.dto.CartAddDTO;
import com.exam.haibazo.model.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    Cart toEntity(CartAddDTO dto);
    CartAddDTO toDto(Cart entity);
}

