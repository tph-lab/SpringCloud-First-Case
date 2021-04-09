package com.yc.piclib.springcloud812;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient //启用服务发现客户端，获取当前provider的注册信息
@EnableCircuitBreaker //开启熔断机制
public class ProviderApp_hystrix {

    public static void main(String[] args) {

        SpringApplication.run(ProviderApp_hystrix.class, args);
    }

}
