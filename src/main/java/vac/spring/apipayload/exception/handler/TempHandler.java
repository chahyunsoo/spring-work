package vac.spring.apipayload.exception.handler;

import vac.spring.apipayload.code.BaseErrorCode;
import vac.spring.apipayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
