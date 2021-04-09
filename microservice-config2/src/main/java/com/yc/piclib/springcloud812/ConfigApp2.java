package com.yc.piclib.springcloud812;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer         //启动配置中心（服务器）
@EnableEurekaClient
public class ConfigApp2 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApp2.class, args);
    }
}