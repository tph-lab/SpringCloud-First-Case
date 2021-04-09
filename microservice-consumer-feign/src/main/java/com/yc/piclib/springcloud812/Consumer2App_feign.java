package com.yc.piclib.springcloud812;

import com.yc.piclib.springcloud812.robinConfiguration.RobinConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient    //启用eureka客户端，这样能完成服务发现
//指定这个新的负载算法类  给MICROSERVICE-PROVIDER这个服务用
//这里的name  只是服务的名称  如果需要多个服务提供方，这个时候可以使用@RibbonClients进行配置
//只对服务名为MICROSERVICE-PROVIDER下的服务清单采用RobinConfigure指定的随机负载均衡方式
@RibbonClient(name = "MICROSERVICE-PROVIDER", configuration = RobinConfigure.class)
//如有多个服务要用不同的策略，则采用@RibbonClients
@EnableFeignClients("com.yc.piclib.springcloud812.service")
//启用Feign客户端，告诉feign操作接口的路径，
// 这样feign可以扫描这个路径下的接口@Feignclient的接口，并生成动态代理对象

public class Consumer2App_feign {


    public static void main(String[] args) {
        SpringApplication.run(Consumer2App_feign.class, args);
    }

}
