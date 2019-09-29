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
package com.yh.common.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yh.common.enums.ResultState;
import lombok.Data;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yangheng
 * @create 2019/9/29
 * @since 1.0.0
 */
@Data
public class BaseResult {

    private ResultState state = ResultState.SUCCESS;
    private String message = "执行成功";
    /**
     * 000000代表成功
     */
    private String code = "000000";
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date timestamp = new Date();

    /**
     * 默认成功
     */
    public BaseResult() {
        //无参构造
    }


    public BaseResult errorResult() {
        this.state = ResultState.FAIL;
        this.message = "执行失败";
        this.code = "400";
        return this;
    }
}