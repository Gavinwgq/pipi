package com.gavin.pipi.service.impl;

import com.gavin.pipi.entity.RoleMenu;
import com.gavin.pipi.dao.RoleMenuMapper;
import com.gavin.pipi.service.IRoleMenuService;
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
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {
    private static final Logger logger = LoggerFactory.getLogger(RoleMenuServiceImpl.class);
}
