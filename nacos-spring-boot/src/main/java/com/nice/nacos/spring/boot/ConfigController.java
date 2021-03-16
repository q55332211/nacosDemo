package com.nice.nacos.spring.boot;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.google.common.collect.Lists;
import com.nice.nacos.spring.boot.service.ConfigService;
import com.nice.nacos.spring.boot.thread.MyCallable;
import com.nice.nacos.spring.boot.thread.MyThreadFactory;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.catalina.Executor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


@Controller
@RequestMapping("config")
@Slf4j
public class ConfigController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @Autowired
    private ConfigService configService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public boolean get() throws ExecutionException, InterruptedException {
        String stringData = configService.getStringData(10, 5);
        log.info("str -- >{}",stringData);
        return useLocalCache;
    }

    @RequestMapping(value = "/getApplicationContent", method = RequestMethod.GET)
    public void getApplicationContent(HttpServletRequest request) {
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        ConfigService bean = applicationContext.getBean(ConfigService.class);
        /*try {
            String stringData = bean.getStringData(1, 10);
            log.info(stringData);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}