package com.exam.haibazo.mapper;

import com.exam.haibazo.dto.OrderDTO;
import com.exam.haibazo.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OrderItemMapper.class})
public interface OrderMapper {

    OrderDTO toDTO(Order order);

    Order toEntity(OrderDTO orderDTO);
}


