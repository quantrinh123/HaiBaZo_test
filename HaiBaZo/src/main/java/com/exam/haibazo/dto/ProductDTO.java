package com.exam.haibazo.dto;

import com.exam.haibazo.model.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ProductDTO {
     Long productId;
     String name;
     String description;
     BigDecimal price;
     BigDecimal originalPrice;
     private String image;
     int stockQuantity;
     Date offerEndTime;
     int views;

     CategoryDTO category;
     List<StyleDTO> styles;
     List<ColorDTO> colors;
     List<SizeDTO> sizes;
     List<CartAddDTO> carts;

}

