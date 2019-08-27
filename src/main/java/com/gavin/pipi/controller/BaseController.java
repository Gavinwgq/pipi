package com.gavin.pipi.controller;
import	java.security.Identity;

import com.gavin.pipi.utils.IdWorker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangguoqiang
 * @version V1.0
 * @date: 2019/8/27 10:19
 */
@RestController
@RequestMapping("/base")
public class BaseController {

    public long genId(){
        IdWorker idWorker = new IdWorker(0, 0);
        return idWorker.nextId();
    }
}
