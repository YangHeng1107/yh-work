/**
 * *****************************************************
 * Copyright (C) 2019 bytedance.com. All Rights Reserved
 * This file is part of bytedance EA project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 * <p>
 * History:
 * <author>            <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号            描述
 */
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