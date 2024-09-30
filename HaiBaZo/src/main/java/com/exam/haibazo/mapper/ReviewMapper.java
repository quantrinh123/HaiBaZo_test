package com.exam.haibazo.mapper;

import com.exam.haibazo.dto.ReviewDTO;
import com.exam.haibazo.model.Review;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    @Mapping(target = "productId", source = "product.productId")
    ReviewDTO reviewToReviewDTO(Review review);

    List<ReviewDTO> reviewsToReviewDTOs(List<Review> reviews);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", ignore = true)
    Review reviewDTOToReview(ReviewDTO reviewDTO);
}