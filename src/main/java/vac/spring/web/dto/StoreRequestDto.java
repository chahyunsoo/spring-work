package vac.spring.web.dto;

import lombok.Getter;
import vac.spring.validation.annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StoreRequestDto {

    @Getter
    public static class ReveiwDto{
        @NotBlank
        String title;
        @NotNull
        Float score;
        @NotBlank
        String body;
    }
}