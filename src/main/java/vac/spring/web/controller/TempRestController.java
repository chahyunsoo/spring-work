package vac.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vac.spring.apipayload.ApiResponse;
import vac.spring.converter.TempConverter;
import vac.spring.service.TempService.TempQueryService;
import vac.spring.web.dto.TempResponse;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {
    private final TempQueryService tempQueryService;
    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDto> testApi() {
        return ApiResponse.onSuccess(TempConverter.tempTestDto());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDto> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.checkFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDto(flag));
    }
}
