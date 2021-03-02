package com.kaka.wms_service.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *  发货模块
 */
@RestController
@RequestMapping("/wms")
public class WmsController {


    @RequestMapping(value = "/delivery/{productId}", method = RequestMethod.PUT)
    public String delivery(@PathVariable("productId") Long productId) {
        System.out.println("对商品【productId=" + productId + "】进行发货");
        return "{'msg': 'success'}";
    }
}
