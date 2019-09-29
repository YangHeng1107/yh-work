
package com.yh.common.enums;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author yangheng
 * @create 2019/9/29
 * @since 1.0.0
 */
public enum ResponseCode {

    /**
     *
     */
    SERVICE_ERROR("500100","服务器发生异常!"),


    PARAM_ERROR("500000","请求参数错误!");

    private String code;
    private String msg;

    ResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}