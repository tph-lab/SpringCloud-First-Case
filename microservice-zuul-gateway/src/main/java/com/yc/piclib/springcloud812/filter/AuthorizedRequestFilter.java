package com.yc.piclib.springcloud812.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * zuul的自定义过滤器
 */
public class AuthorizedRequestFilter extends ZuulFilter {

    //filter类型：
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;   //  "pre"
    }

    //优先级
    @Override
    public int filterOrder() {
        return 0;
    }

    //是否生效
    @Override
    public boolean shouldFilter() {
        return true;
    }


    /*
         HttpHeaders headers=new HttpHeaders();
         String auth="admin:a";   //认证的原始用户名和密码
         byte[] encodeAuth= Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII"))); //加密处理
         String authHeader="Basic "+new String(encodeAuth);
         headers.set("Authorization",authHeader);    //    Http请求头         Authorization: Base xxxxxxxxx
      */
    @Override   //这个用于将敏感信息  admin:a 存入到请求头
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext(); // 获取当前请求的上下文

        String auth = "admin:a"; // 认证的原始信息
        byte[] encodedAuth = Base64.getEncoder()
                .encode(auth.getBytes(Charset.forName("US-ASCII"))); // 进行一个加密的处理
        String authHeader = "Basic " + new String(encodedAuth);
        currentContext.addZuulRequestHeader("Authorization", authHeader);
        return null;
    }
}