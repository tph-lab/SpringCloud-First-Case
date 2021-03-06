package com.yc.piclib.springcloud812.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity   //  启用安全
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder()).withUser("root")
                .password(new BCryptPasswordEncoder().encode("a"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(new BCryptPasswordEncoder().encode("a"))
                .roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests().anyRequest()
                .fullyAuthenticated();
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        //book要权限  user不用
        //不管是什么服务，只要是访问这两个服务的/actuator/hystrix.stream","/turbine.stream，不用加权限验证
        web.ignoring().antMatchers("/actuator/hystrix.stream", "/turbine.stream");
    }
}
