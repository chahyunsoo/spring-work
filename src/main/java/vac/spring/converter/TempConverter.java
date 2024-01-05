package vac.spring.converter;

import vac.spring.web.dto.TempResponse;

public class TempConverter {
    public static TempResponse.TempTestDto tempTestDto() {
        return TempResponse.TempTestDto.builder()
                .testString("test")
                .build();
    }
    public static TempResponse.TempExceptionDto toTempExceptionDto(Integer flag){
        return TempResponse.TempExceptionDto.builder()
                .flag(flag)
                .build();
    }
}
