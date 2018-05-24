package com.weidong.blog.staticservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"com.weidong.blog.staticservice","com.weidong.blog.commons"})
@EnableDiscoveryClient
public class BlogStaticServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogStaticServiceApplication.class, args);
    }
}
