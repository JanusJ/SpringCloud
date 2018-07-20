package com.web.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
	
	@LoadBalanced//开启负载均衡机制
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate(); // 用来进行HTTP通信
    }

}
