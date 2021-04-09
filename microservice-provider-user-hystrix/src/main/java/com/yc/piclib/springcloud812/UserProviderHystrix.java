package com.yc.piclib.springcloud812;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
//@EnableDiscoveryClient //启用服务发现客户端，获取当前provider的注册信息
@EnableCircuitBreaker//熔断
public class UserProviderHystrix {
    public static void main(String[] args) {

        SpringApplication.run(UserProviderHystrix.class, args);
    }
}
