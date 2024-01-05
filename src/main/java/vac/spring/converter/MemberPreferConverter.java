package vac.spring.converter;

import vac.spring.domain.FoodCategory;
import vac.spring.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {
    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList) {
        return foodCategoryList.stream()
                .map(f->
                        MemberPrefer.builder()
                                .foodCategory(f)
                                .build()).collect(Collectors.toList());
    }
}
