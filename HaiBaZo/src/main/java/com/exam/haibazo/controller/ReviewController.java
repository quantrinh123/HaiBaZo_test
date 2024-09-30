package com.exam.haibazo.controller;

import com.exam.haibazo.dto.ReviewDTO;
import com.exam.haibazo.service.IReviewService;
import com.exam.haibazo.service.impl.ReviewService;
import com.exam.haibazo.util.JsonResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewController {
     IReviewService reviewService;

    @GetMapping("/{productId}/reviews")
    public ResponseEntity<?> getProductReviews(@PathVariable Long productId) {
        List<ReviewDTO> reviews = reviewService.getReviewsByProductId(productId);
        return JsonResponse.ok(reviews);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<?> getReviewById(@PathVariable Long reviewId) {
        ReviewDTO review = reviewService.getReviewById(reviewId);
        return JsonResponse.ok(review);
    }

    @PostMapping("/{productId}/reviews")
    public ResponseEntity<?> createReview(@PathVariable Long productId, @RequestBody ReviewDTO reviewDTO) {
        reviewDTO.setProductId(productId);
        ReviewDTO createdReview = reviewService.createReview(reviewDTO);
        return  JsonResponse.create(createdReview);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }
}
