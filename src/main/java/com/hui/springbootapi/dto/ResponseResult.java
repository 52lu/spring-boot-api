package com.hui.springbootapi.dto;

import com.hui.springbootapi.enums.ResponseCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseResult<T> {
    private int code;
    private String msg;
    private T data;
    ResponseResult(ResponseCodeEnum responseCodeEnum,T data){
        this.code = responseCodeEnum.code;
        this.msg = responseCodeEnum.msg;
        this.data = data;
    }
    ResponseResult(ResponseCodeEnum responseCodeEnum){
        this.code = responseCodeEnum.code;
        this.msg = responseCodeEnum.msg;
    }

    /**
     * 处理错误,自定义错误信息
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> error(String msg){
        ResponseCodeEnum.ERROR.msg = msg;
        return new ResponseResult<T>(ResponseCodeEnum.ERROR,null);
    }

    /**
     * 根据responseCodeEnum
     * @param responseCodeEnum
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> error(ResponseCodeEnum responseCodeEnum){

        return new ResponseResult<T>(responseCodeEnum);
    }

    /**
     * 处理错误,自定义错误信息
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> error(Integer code ,String msg){
        ResponseCodeEnum.ERROR.code = code;
        ResponseCodeEnum.ERROR.msg = msg;
        return new ResponseResult<T>(ResponseCodeEnum.ERROR,null);
    }


    /***
     * 处理成功，无数据返回
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> success(){
        return new ResponseResult<T>(ResponseCodeEnum.SUCCESS,null);
    }
    /**
     * 处理成功，并有数据返回
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> success(T data){
        return new ResponseResult<T>(ResponseCodeEnum.SUCCESS,data);
    }

}
