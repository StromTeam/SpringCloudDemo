package com.kaka.credit_service.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *  用户积分模块
 */
@RestController
@RequestMapping("/credit")
public class CreditController {


    /**
     * 用户增加积分
     * @param userId
     * @param credit
     * @return
     */
    @RequestMapping(value = "/add/{userId}/{credit}", method = RequestMethod.PUT)
    public String add(@PathVariable("userId") Long userId,
                      @PathVariable("credit") Long credit) {
        System.out.println("对用户【userId=" + userId + "】增加积分：" + credit);
        return "{'msg': 'success'}";
    }
}
