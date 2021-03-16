package com.nice.nacos.spring.boot.thread;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Create: nice
 * @Description:
 * @Date: Create in 17:03 2021/3/16
 */
@Component("myExecutorService")
public class MyExecutorService {

    @Value("${corePoolSize}")
    private static Integer corePoolSize = 10;

    private static ExecutorService executorService = Executors.newFixedThreadPool(corePoolSize, new MyThreadFactory());

    public ExecutorService getExecutorService() {
        return executorService;
    }

}
