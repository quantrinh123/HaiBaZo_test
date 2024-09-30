package com.exam.haibazo.controller;

import com.exam.haibazo.dto.ApiResponse;
import com.exam.haibazo.dto.BuyNowDTO;
import com.exam.haibazo.dto.OrderDTO;
import com.exam.haibazo.model.Order;
import com.exam.haibazo.service.IOrderService;
import com.exam.haibazo.util.JsonResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {

    private final IOrderService orderService;

    @PostMapping("/buy-now")
    public ResponseEntity<ApiResponse<Order>> buyNow(@RequestBody BuyNowDTO buyNowDTO) {
        Order order = orderService.buyNow(buyNowDTO);
        return JsonResponse.ok(order);
    }
}
