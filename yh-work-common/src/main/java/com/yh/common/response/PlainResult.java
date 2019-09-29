package com.yh.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author yangheng
 * @create 2019/9/29
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlainResult<T> extends BaseResult {
    private T data;
}