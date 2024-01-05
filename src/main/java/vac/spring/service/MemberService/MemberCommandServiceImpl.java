package vac.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vac.spring.apipayload.code.status.ErrorStatus;
import vac.spring.apipayload.exception.handler.FoodCategoryHandler;
import vac.spring.converter.MemberConverter;
import vac.spring.converter.MemberPreferConverter;
import vac.spring.domain.FoodCategory;
import vac.spring.domain.Member;
import vac.spring.domain.mapping.MemberPrefer;
import vac.spring.repository.FoodCategoryRepository;
import vac.spring.repository.MemberRepository;
import vac.spring.web.dto.MemberRequestDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService {
    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public Member joinMember(MemberRequestDto.JoinDto request) {
        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(c -> {
                    return foodCategoryRepository.findById(c).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                })
                .collect(Collectors.toList());
        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);
        memberPreferList.forEach(m -> {
            m.setMember(newMember);
        });

        return memberRepository.save(newMember);
    }
}
