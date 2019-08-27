package com.gavin.pipi.service.impl;

import com.gavin.pipi.entity.Menu;
import com.gavin.pipi.dao.MenuMapper;
import com.gavin.pipi.service.IMenuService;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
}
