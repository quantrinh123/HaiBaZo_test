package com.exam.haibazo.mapper;

import com.exam.haibazo.dto.OrderItemDTO;
import com.exam.haibazo.model.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface OrderItemMapper {

    OrderItemDTO toDTO(OrderItem orderItem);

    OrderItem toEntity(OrderItemDTO orderItemDTO);
}
