package com.yh.common.exceptions;

import com.yh.common.enums.ResponseCode;
import com.yh.common.enums.ResultState;
import com.yh.common.response.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yangheng
 * @create 2019/9/29
 * @since 1.0.0
 */
@ControllerAdvice
@Slf4j
@RestController
public class GlobalDefaultExceptionHandler {

    private BaseResult failResult(ResponseCode responseCode){
        BaseResult baseResult = new BaseResult();
        baseResult.setState(ResultState.FAIL);
        baseResult.setCode(responseCode.code());
        baseResult.setMessage(responseCode.msg());
        return baseResult;
    }

    private BaseResult failResult(ResponseCode responseCode, String msg){
        BaseResult baseResult = new BaseResult();
        baseResult.setState(ResultState.FAIL);
        baseResult.setCode(responseCode.code());
        baseResult.setMessage(msg);
        return baseResult;
    }

    private BaseResult failResult(String code, String msg){
        BaseResult baseResult = new BaseResult();
        baseResult.setState(ResultState.FAIL);
        baseResult.setCode(code);
        baseResult.setMessage(msg);
        return baseResult;
    }

    @ExceptionHandler({Exception.class})
    public BaseResult handleException(Exception e) {
       log.error("服务器发生异常!",e);
       //服务器异常时 非Response能直接预知的，这里补充异常的消息
       return failResult(ResponseCode.SERVICE_ERROR,e.getMessage());
    }

    /**
     * apiException处理  接口层异常
     * @param agileException 敏捷中心异常
     * @return
     */
    @ExceptionHandler(ApiException.class)
    public BaseResult handleAgileException(ApiException agileException){
        log.error("接口异常", agileException);
        return failResult(agileException.getCode(), agileException.getMessage());
    }

    /**
     * springboot 参数格式转换错误时的异常
     * @param exception
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaseResult handleHttpMessageNotReadableException(HttpMessageNotReadableException exception){
        log.warn("请求参数格式不正确，json转换错误");
        return failResult(ResponseCode.PARAM_ERROR);
    }
}
