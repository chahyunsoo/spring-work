package vac.spring.service.MemberService;

import vac.spring.domain.Member;

import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findMember(Long id);

}
