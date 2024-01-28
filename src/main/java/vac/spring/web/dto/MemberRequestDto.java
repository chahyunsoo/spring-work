package vac.spring.web.dto;

import lombok.Getter;
import vac.spring.validation.annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class MemberRequestDto {
    @Getter
    public static class JoinDto {
        @NotBlank
        String namee;
        @NotNull
        Integer genderr;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonthr;
        @NotNull
        Integer birthDayyy;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }
}
