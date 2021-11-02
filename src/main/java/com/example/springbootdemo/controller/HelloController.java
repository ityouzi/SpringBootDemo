package com.example.springbootdemo.controller;

import com.example.springbootdemo.service.MsgService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 控制层
 *
 * @author lizhen created on 2021-10-18 17:14
 * @version 1.0
 */
@RestController
@RequestMapping("/")
public class HelloController {

    @Resource
    private MsgService msgService;

    @GetMapping("/send")
    public void send(){
        msgService.send();
    }
}
