package vac.spring.apipayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import vac.spring.apipayload.code.BaseErrorCode;
import vac.spring.apipayload.code.ErrorReasonDto;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private BaseErrorCode code;

    public ErrorReasonDto getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDto getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
