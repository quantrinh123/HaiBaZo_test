package com.exam.haibazo.service.impl;

import com.exam.haibazo.dto.ProductDTO;
import com.exam.haibazo.exception.ApiException;
import com.exam.haibazo.exception.ErrorCode;
import com.exam.haibazo.mapper.ProductMapper;
import com.exam.haibazo.model.Product;
import com.exam.haibazo.repository.ProductRepository;
import com.exam.haibazo.service.IProductService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductService implements IProductService {

   ProductRepository productRepository;

     ProductMapper productMapper;

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new ApiException(ErrorCode.PRODUCT_NOT_EXIST);
        }
        return products.stream().map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.PRODUCT_NOT_EXIST));
        return productMapper.toProductDTO(product);
    }


    public Product save(Product product){

        return productRepository.save(product);
    }
    public List<ProductDTO> filterProducts(String category, String color, String size, Double priceMin, Double priceMax, String style) {
        List<Product> filteredProducts = productRepository.findByFilters(category, color, size, priceMin, priceMax, style);

        if (filteredProducts.isEmpty()) {
            throw new ApiException(ErrorCode.PRODUCT_NOT_EXIST);
        }
        return filteredProducts.stream()
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }




}

