package com.yc.piclib.springcloud821.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
//需要热加载的bean需要加上@RefreshScope注解，当配置发生变更的时候可以在不重启应用的前提下完成bean中相关属性的刷新。
@RefreshScope           //config中的注解，自动刷新，代表这个类是可用基于rabbitmq自动刷新的
public class InfoConfig {

    @Value("${info.app.name}")
    private String appName;

    @Value("${info.company.name}")
    private String companyName;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "InfoConfig{" +
                "appName='" + appName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}