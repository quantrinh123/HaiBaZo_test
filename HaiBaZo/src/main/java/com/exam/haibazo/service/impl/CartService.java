package com.exam.haibazo.service.impl;

import com.exam.haibazo.dto.CartAddDTO;
import com.exam.haibazo.exception.ApiException;
import com.exam.haibazo.exception.ErrorCode;
import com.exam.haibazo.mapper.CartMapper;
import com.exam.haibazo.model.Cart;
import com.exam.haibazo.model.Product;
import com.exam.haibazo.repository.CartRepository;
import com.exam.haibazo.repository.ProductRepository;
import com.exam.haibazo.service.ICartService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartService implements ICartService {

     CartRepository cartRepository;

     ProductRepository productRepository;

    CartMapper cartMapper;

    public Cart addToCart(CartAddDTO cartAddDTO) {
        // Kiểm tra null cho productId
        if (cartAddDTO.getProductId() == null) {
            throw new IllegalArgumentException("Product ID must not be null");
        }

        Product product = productRepository.findById(cartAddDTO.getProductId())
                .orElseThrow(() -> new ApiException(ErrorCode.PRODUCT_NOT_EXIST));

        Cart cart = cartMapper.toEntity(cartAddDTO);
        cart.setProduct(product);
        cart.setQuantity(cartAddDTO.getQuantity());
        return cartRepository.save(cart);
    }

}
