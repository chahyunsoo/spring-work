package vac.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vac.spring.apipayload.ApiResponse;
import vac.spring.converter.StoreConverter;
import vac.spring.domain.Review;
import vac.spring.service.StoreService.StoreCommandService;
import vac.spring.validation.annotation.ExistMember;
import vac.spring.validation.annotation.ExistStore;
import vac.spring.web.dto.StoreRequestDto;
import vac.spring.web.dto.StoreResponseDto;

import javax.validation.Valid;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDto.CreateReviewResultDTO> createReview(@RequestBody @Valid StoreRequestDto.ReveiwDto request,
                                                                            @ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                            @ExistMember @RequestParam(name = "memberId") Long memberId){
        Review review = storeCommandService.createReview(memberId, storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreateReviewResultDTO(review));
    }
}