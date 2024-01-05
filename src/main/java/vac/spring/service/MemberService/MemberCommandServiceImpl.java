package vac.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vac.spring.domain.Member;
import vac.spring.repository.MemberRepository;
import vac.spring.web.dto.MemberRequestDto;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{
    private final MemberRepository memberRepository;

    @Override
    public Member joinMember(MemberRequestDto.JoinDto request) {
        return null;
    }
}
