package vac.spring.apipayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"}) //JSON 직렬화 순서를 제어함
public class ApiResponse<T> {
    @JsonProperty("isSuccess")
    private final Boolean success;
    private final String code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL) //객체의 NULL 필드 노출 X
    private T data;

    //성공한 경우 응답 생성
    public static <T> ApiResponse<T> onSuccess(T data) {
        return new ApiResponse<>(true, SuccessStatus._OK.getCode(), SuccessStatus._OK.getMessage(), data);
    }
    public static <T> ApiResponse<T> of(BaseCode code, T result){
        return new ApiResponse<>(true, code.getReasonHttpStatus().getCode() , code.getReasonHttpStatus().getMessage(), result);
    }

    //실패할 경우 응답 생성
    public static <T> ApiResponse<T> onSuccess(String code,String message,T data) {
        return new ApiResponse<>(true, code, message, data);
    }

}
