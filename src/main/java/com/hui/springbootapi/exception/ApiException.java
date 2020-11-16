package com.hui.springbootapi.exception;

import com.hui.springbootapi.enums.ResponseCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiException extends RuntimeException {
    private Integer code;
    private String msg;
    public ApiException(ResponseCodeEnum responseCodeEnum){
        super(responseCodeEnum.msg);
        this.code = responseCodeEnum.code;
        this.msg = responseCodeEnum.msg;

    }
}
