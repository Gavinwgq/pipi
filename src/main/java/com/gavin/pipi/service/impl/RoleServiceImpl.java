package com.gavin.pipi.service.impl;

import com.gavin.pipi.entity.Role;
import com.gavin.pipi.dao.RoleMapper;
import com.gavin.pipi.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
}
