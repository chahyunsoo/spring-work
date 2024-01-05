package vac.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vac.spring.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
