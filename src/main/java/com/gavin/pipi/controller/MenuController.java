package com.gavin.pipi.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangguoqiang
 * @since 2019-08-24
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
}

