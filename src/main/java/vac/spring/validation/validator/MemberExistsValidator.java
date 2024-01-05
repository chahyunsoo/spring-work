package vac.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
//import vac.spring.apiPayload.code.status.ErrorStatus;
import vac.spring.apipayload.code.status.ErrorStatus;
import vac.spring.domain.Member;
import vac.spring.service.MemberService.MemberQueryService;
import vac.spring.validation.annotation.ExistMember;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MemberExistsValidator implements ConstraintValidator<ExistMember, Long> {

    private final MemberQueryService memberQueryService;

    @Override
    public void initialize(ExistMember constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Optional<Member> target = memberQueryService.findMember(value);

        if (target.isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}