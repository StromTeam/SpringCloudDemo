package com.kaka.api_service.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    public String add(@PathVariable("userId") Long userId,
                      @PathVariable("credit") Long credit) {
        System.out.println("对用户【userId=" + userId + "】增加积分：" + credit);
        return "{'msg': 'success'}";
    }
}
