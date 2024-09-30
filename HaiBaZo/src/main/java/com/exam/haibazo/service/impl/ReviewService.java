package com.exam.haibazo.service.impl;

import com.exam.haibazo.dto.ReviewDTO;
import com.exam.haibazo.mapper.ReviewMapper;
import com.exam.haibazo.model.Product;
import com.exam.haibazo.model.Review;
import com.exam.haibazo.repository.ProductRepository;
import com.exam.haibazo.repository.ReviewRepository;
import com.exam.haibazo.service.IReviewService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class ReviewService implements IReviewService {
     ReviewRepository reviewRepository;
     ProductRepository productRepository;
     ReviewMapper reviewMapper;

    public List<ReviewDTO> getReviewsByProductId(Long productId) {
        List<Review> reviews = reviewRepository.findByProductId(productId);
        return reviews.stream().map(reviewMapper::reviewToReviewDTO)
                .collect(Collectors.toList());
    }

    public ReviewDTO getReviewById(Long reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new EntityNotFoundException("Review not found with id: " + reviewId));
        return reviewMapper.reviewToReviewDTO(review);
    }

    public ReviewDTO createReview(ReviewDTO reviewDTO) {
        Product product = productRepository.findById(reviewDTO.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + reviewDTO.getProductId()));

        Review review = reviewMapper.reviewDTOToReview(reviewDTO);
        review.setProduct(product);
        Review savedReview = reviewRepository.save(review);
        return reviewMapper.reviewToReviewDTO(savedReview);
    }

    public void deleteReview(Long reviewId) {
        if (!reviewRepository.existsById(reviewId)) {
            throw new EntityNotFoundException("Review not found with id: " + reviewId);
        }
        reviewRepository.deleteById(reviewId);
    }
}
