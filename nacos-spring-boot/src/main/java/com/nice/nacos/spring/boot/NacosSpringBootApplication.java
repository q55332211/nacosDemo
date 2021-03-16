package com.nice.nacos.spring.boot;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.nice.nacos.spring.boot.thread.MyExecutorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
//@NacosPropertySource(dataId = "nice", autoRefreshed = true, groupId = "niceGroup")
@ImportAutoConfiguration(MyExecutorService.class)
public class NacosSpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosSpringBootApplication.class, args);
        SpringBeanUtils.applicationContext=applicationContext;
    }

}
