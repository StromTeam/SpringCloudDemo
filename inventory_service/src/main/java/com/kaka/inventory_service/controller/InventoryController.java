package com.kaka.inventory_service.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 *  库存模块
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @RequestMapping(value = "/deduct/{productId}/{stock}", method = RequestMethod.PUT)
    public String deductStock(@PathVariable("productId") Long productId,
                              @PathVariable("stock") Long stock) {
        System.out.println("对商品【productId=" + productId + "】扣减库存：" + stock);
        return "{'msg': 'success'}";
    }
}
