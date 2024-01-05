package vac.spring.converter;

import vac.spring.domain.Review;
import vac.spring.web.dto.StoreRequestDto;
import vac.spring.web.dto.StoreResponseDto;

import java.time.LocalDateTime;

public class StoreConverter {

    public static Review toReview(StoreRequestDto.ReveiwDto request){
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .body(request.getBody())
                .build();
    }

    public static StoreResponseDto.CreateReviewResultDTO toCreateReviewResultDTO(Review review){
        return StoreResponseDto.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}