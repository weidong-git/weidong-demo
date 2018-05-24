package com.weidong.blog.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.weidong.blog.webservice","com.weidong.blog.commons"})
@EnableFeignClients("com.weidong.blog.commons")
@EnableDiscoveryClient//发现服务
public class BlogWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogWebServiceApplication.class, args);
    }
}
