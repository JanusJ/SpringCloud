package com.web.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class ConfigBean {
	
	@LoadBalanced//开启负载均衡机制
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate(); // 用来进行HTTP通信
    }
	
//	@Bean
//	public IRule myRule(){
//		return new RandomRule();
//	}

}
