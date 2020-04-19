package com.jr.couponkeeper.merchants;

import com.jr.couponkeeper.merchants.security.AuthCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@SpringBootApplication
public class MerchantsApplication implements WebMvcConfigurer {

    @Resource
    //@Autowired
    private AuthCheckInterceptor authCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //所有以/merchant开头的所有url进行拦截
        //但除了create，因为第一次建立账号并没有得到token
        registry.addInterceptor(authCheckInterceptor).addPathPatterns("/merchant/**").excludePathPatterns("/merchant/create");
    }

    public static void main(String[] args) {
        SpringApplication.run(MerchantsApplication.class, args);



    }

}
