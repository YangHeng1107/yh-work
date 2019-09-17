package com.yh.dal.manager.impl;

import com.yh.dal.entity.mysql.UserInfoPo;
import com.yh.dal.mapper.UserInfoMapper;
import com.yh.dal.manager.UserInfoManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author v-yangheng.ea
 * @since 2019-09-17
 */
@Service
public class UserInfoManagerImpl extends ServiceImpl<UserInfoMapper, UserInfoPo> implements UserInfoManager {

}
