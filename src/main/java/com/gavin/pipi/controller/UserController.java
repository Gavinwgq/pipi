package com.gavin.pipi.controller;


import com.gavin.pipi.entity.User;
import com.gavin.pipi.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangguoqiang
 * @since 2019-08-24
 */
@Api(value = "用户控制器")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "查询单个用户",notes = "查询单个用户",tags = "user",httpMethod = "GET")
    @GetMapping("/{id}")
    public User getUser(@PathVariable long id){
        User user = userService.selectById(id);
        user.setUserPassword(null);
        return user;
    }

    @ApiOperation(value = "新增用户",notes = "新增用户",tags = "user",httpMethod = "POST")
    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        user.setUserId(genId());
        userService.insert(user);
    }
}

