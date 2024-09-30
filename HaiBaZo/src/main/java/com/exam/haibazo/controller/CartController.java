package com.exam.haibazo.controller;

import com.exam.haibazo.dto.ApiResponse;
import com.exam.haibazo.dto.CartAddDTO;
import com.exam.haibazo.exception.ErrorCode;
import com.exam.haibazo.model.Cart;
import com.exam.haibazo.service.ICartService;
import com.exam.haibazo.util.JsonResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartController {
    ICartService cartService;
    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Cart>> addToCart(@RequestBody CartAddDTO cartAddDTO) {
        Cart cart = cartService.addToCart(cartAddDTO);
        return JsonResponse.ok(cart);
    }


}

