package com.gavin.pipi.service.impl;

import com.gavin.pipi.entity.User;
import com.gavin.pipi.dao.UserMapper;
import com.gavin.pipi.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangguoqiang
 * @since 2019-08-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
}
