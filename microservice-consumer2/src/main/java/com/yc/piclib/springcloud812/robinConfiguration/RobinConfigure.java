package com.yc.piclib.springcloud812.robinConfiguration;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

//这个类暂时不会被spring托管
public class RobinConfigure {
    @Bean
    public IRule ribbonRule() {//其中IRule就是所有规则的标准
        return new com.netflix.loadbalancer.RandomRule();//随机访问的策略

    }

}
