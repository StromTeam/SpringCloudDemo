package com.kaka.order_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *  订单模块
 */
@RestController
@RequestMapping("/value")
public class OrderController {


//    @Autowired
//    private InventoryService inventoryService;
//    @Autowired
//    private WmsService wmsService;
//    @Autowired
//    private CreditService creditService;
//
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String greeting(
            @RequestParam("productId") Long productId,
            @RequestParam("userId") Long userId,
            @RequestParam("count") Long count,
            @RequestParam("totalPrice") Long totalPrice) {
        System.out.println("创建订单");
//        inventoryService.deductStock(productId, count);
//        wmsService.delivery(productId);
//        creditService.add(userId, totalPrice);
        return "success";
    }
}
