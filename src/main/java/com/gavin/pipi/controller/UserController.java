package com.gavin.pipi.controller;


import com.gavin.pipi.entity.User;
import com.gavin.pipi.service.IUserService;
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
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id){
        User user = userService.selectById(id);
        user.setUserPassword(null);
        return user;
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        user.setUserId(genId());
        userService.insert(user);
    }
}

