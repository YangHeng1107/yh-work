
package com.yh.common.exceptions;

import com.yh.common.enums.ResponseCode;
import lombok.Data;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yangheng
 * @create 2019/9/29
 * @since 1.0.0
 */
@Data
public class ApiException extends RuntimeException {
    private final String code;


    public ApiException(String msg, Throwable cause) {
        super(msg, cause);
        this.code = "501";
    }

    public ApiException(String msg) {
        super(msg);
        this.code = "501";
    }

    public ApiException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public ApiException(ResponseCode responseCode) {
        super(responseCode.msg());
        this.code = responseCode.code();
    }

    public ApiException(ResponseCode responseCode, String msg) {
        super(responseCode.msg() + ":" + msg);
        this.code = responseCode.code();
    }
}