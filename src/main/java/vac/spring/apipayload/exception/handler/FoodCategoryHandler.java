package vac.spring.apipayload.exception.handler;

import vac.spring.apipayload.code.BaseErrorCode;
import vac.spring.apipayload.code.status.ErrorStatus;
import vac.spring.apipayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
