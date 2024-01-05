package vac.spring.service.MemberService;

import vac.spring.domain.Member;
import vac.spring.web.dto.MemberRequestDto;

public interface MemberCommandService {
    Member joinMember(MemberRequestDto.JoinDto request);
}
