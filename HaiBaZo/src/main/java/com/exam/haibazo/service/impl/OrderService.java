package com.exam.haibazo.service.impl;

import com.exam.haibazo.dto.BuyNowDTO;

import com.exam.haibazo.enums.OrderStatus;
import com.exam.haibazo.exception.ApiException;
import com.exam.haibazo.exception.ErrorCode;
import com.exam.haibazo.model.Order;
import com.exam.haibazo.model.OrderItem;
import com.exam.haibazo.model.Product;
import com.exam.haibazo.repository.OrderRepository;
import com.exam.haibazo.repository.ProductRepository;
import com.exam.haibazo.service.IOrderService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;


    @Service
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public class OrderService implements IOrderService {

        ProductRepository productRepository;
        OrderRepository orderRepository;


        @Override
        @Transactional
        public Order buyNow(BuyNowDTO buyNowDTO) {
            Product product = productRepository.findById(buyNowDTO.getProductId())
                    .orElseThrow(() -> new ApiException(ErrorCode.PRODUCT_NOT_EXIST));

            if (product.getStockQuantity() < buyNowDTO.getQuantity()) {
                throw new ApiException(ErrorCode.INSUFFICIENT_STOCK);
            }

            Order order = new Order();
            order.setOrderDate(new Date());
            order.setStatus(OrderStatus.PENDING); // Giả sử bạn có enum OrderStatus

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(buyNowDTO.getQuantity());
            orderItem.setUnitPrice(product.getPrice());
            orderItem.setOrder(order);

            order.setOrderItems(Collections.singletonList(orderItem));
            order.setTotalPrice(product.getPrice().multiply(BigDecimal.valueOf(buyNowDTO.getQuantity())));

            product.setStockQuantity(product.getStockQuantity() - buyNowDTO.getQuantity());
            productRepository.save(product);

            return orderRepository.save(order);
        }

}
