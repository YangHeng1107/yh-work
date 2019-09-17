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
package com.yh.web.controller;

import com.yh.biz.TestService;
import com.yh.dal.entity.mysql.UserInfoPo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author yangheng
 * @create 2019/9/17
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/private/test")
public class TestController {

    @Resource
    private TestService tastService;

    @GetMapping("/test")
    public List<UserInfoPo> test() {

        List<UserInfoPo> test = tastService.test();

        return test;
    }
}