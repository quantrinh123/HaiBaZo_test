package com.exam.haibazo.mapper;

import com.exam.haibazo.dto.ProductDTO;
import com.exam.haibazo.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toProductDTO(Product product);

    Product toProductsEntity(ProductDTO productDTO);
}

