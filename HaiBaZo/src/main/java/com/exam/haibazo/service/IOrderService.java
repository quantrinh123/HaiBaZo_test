package com.exam.haibazo.service;

import com.exam.haibazo.dto.BuyNowDTO;
import com.exam.haibazo.dto.OrderDTO;
import com.exam.haibazo.model.Order;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public interface IOrderService {



    @Transactional
    Order buyNow(BuyNowDTO buyNowDTO);
}
