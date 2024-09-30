package com.exam.haibazo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class OrderItemDTO {
     Long orderItemId;
     ProductDTO product;
     int quantity;
     BigDecimal unitPrice;
     BigDecimal subtotal;
}
