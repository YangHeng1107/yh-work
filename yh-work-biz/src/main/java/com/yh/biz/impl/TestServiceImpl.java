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