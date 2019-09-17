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
package com.yh.biz.impl;

import com.yh.biz.TestService;
import com.yh.dal.entity.mysql.UserInfoPo;
import com.yh.dal.manager.UserInfoManager;
import org.springframework.stereotype.Service;

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
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private UserInfoManager userInfoManager;

    @Override
    public List<UserInfoPo> test() {
        return userInfoManager.list();
    }
}