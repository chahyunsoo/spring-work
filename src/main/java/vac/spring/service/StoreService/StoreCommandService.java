package vac.spring.service.StoreService;

import vac.spring.domain.Review;
import vac.spring.web.dto.StoreRequestDto;

public interface StoreCommandService {

    Review createReview(Long memberId, Long storeId, StoreRequestDto.ReveiwDto request);
}