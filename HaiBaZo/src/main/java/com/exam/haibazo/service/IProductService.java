package com.exam.haibazo.service;

import com.exam.haibazo.dto.ProductDTO;
import com.exam.haibazo.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
     List<ProductDTO> getAllProducts();
     ProductDTO findById(Long id);
     Product save(Product product);

     List<ProductDTO> filterProducts(String category, String color, String size, Double priceMin, Double priceMax, String style);

}
