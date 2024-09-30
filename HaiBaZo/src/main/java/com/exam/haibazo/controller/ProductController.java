package com.exam.haibazo.controller;

import com.exam.haibazo.dto.ApiResponse;
import com.exam.haibazo.dto.ProductDTO;
import com.exam.haibazo.service.IProductService;
import com.exam.haibazo.util.JsonResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductController {
   IProductService productService;
    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getAll(){
        List<ProductDTO> products = productService.getAllProducts();
        return JsonResponse.ok(products);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDTO>> getByID(@PathVariable("id") Long id) {
        ProductDTO productDTO = productService.findById(id);
        return JsonResponse.ok(productDTO);
    }

    @GetMapping("/filter")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> filterProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String size,
            @RequestParam(required = false) Double price_min,
            @RequestParam(required = false) Double price_max,
            @RequestParam(required = false) String style) {

        List<ProductDTO> filteredProducts = productService.filterProducts(category, color, size, price_min, price_max, style);
        return JsonResponse.ok(filteredProducts);
    }

//    @PostMapping
//    public ResponseEntity<ApiResponse<Product>> create(@RequestBody Product product){
//        productService.save(product);
//        return JsonResponse.create(product);
//    }
}
