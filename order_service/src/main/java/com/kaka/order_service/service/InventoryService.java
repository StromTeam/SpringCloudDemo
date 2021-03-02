package com.kaka.order_service.service;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "INVENTORY-SERVICE")
public class InventoryService {
}
