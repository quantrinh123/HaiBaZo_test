package com.exam.haibazo.service;

import com.exam.haibazo.dto.ReviewDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IReviewService {
    List<ReviewDTO> getReviewsByProductId(Long productId);

    ReviewDTO getReviewById(Long reviewId);

    ReviewDTO createReview(ReviewDTO reviewDTO);



    void deleteReview(Long reviewId);
}
