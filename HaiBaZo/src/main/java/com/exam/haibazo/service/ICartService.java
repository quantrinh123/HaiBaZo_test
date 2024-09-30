package com.exam.haibazo.service;

import com.exam.haibazo.dto.CartAddDTO;
import com.exam.haibazo.model.Cart;
import org.springframework.stereotype.Service;

@Service
public interface ICartService {
      Cart addToCart(CartAddDTO cartAddDTO);

}
