package com.hui.springbootapi.exception;

import com.hui.springbootapi.dto.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获参数异常处理
     *
     * @param e
     * @param model
     * @return String
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseResult<?> handelMissingServletRequestParameterException(MissingServletRequestParameterException e, Model model) {
        log.error("缺少请求参数", e);
        String message = "缺少请求参数: " + e.getMessage();
        return ResponseResult.error(message);
    }

    /**
     * spring validator 方法参数验证异常拦截
     *
     * @param e 绑定验证异常
     * @return 错误返回消息
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseResult<?> defaultErrorHandler(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = violation.getMessage();
        log.info("数据验证异常：{}", violation.getMessage());
        return ResponseResult.error(message);
    }

    /**
     * 拦截实体类参数(参数前没有@RequestBody注解)校验失败的错误
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ResponseResult<?> bindExceptionHandler(BindException e) {
        ObjectError objectError = e.getAllErrors().get(0);
        log.info("数据验证异常：{}", objectError.getDefaultMessage());
        return ResponseResult.
                error(objectError.getDefaultMessage());
    }

    /**
     * 拦截实体类参数(参数前有@RequestBody注解)校验失败的错误
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return ResponseResult.error(objectError.getDefaultMessage() );
    }

    /**
     * 自定义错误捕捉
     * @param e
     * @return
     */
    @ExceptionHandler(ApiException.class)
    public ResponseResult<?> apiExceptionHandler(ApiException e) {
        return ResponseResult.error(e.getCode(),e.getMsg());
    }
}