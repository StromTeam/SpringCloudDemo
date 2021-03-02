package com.kaka.order_service.service;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "WMS-SERVICE")
public class WmsService {
}
