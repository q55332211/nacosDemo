package com.nice.nacos.spring.boot.service.impl;

import com.google.common.collect.Lists;
import com.nice.nacos.spring.boot.service.ConfigService;
import com.nice.nacos.spring.boot.thread.MyCallable;
import com.nice.nacos.spring.boot.thread.MyExecutorService;
import com.nice.nacos.spring.boot.thread.MyThreadFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Create: nice
 * @Description:
 * @Date: Create in 12:14 2021/3/16
 */
@Service
@Slf4j
public class ConfigServiceImpl implements ConfigService {

    private Integer maxSize = 2;

    @Autowired
    private MyExecutorService myExecutorService;

    @Override
    public String getStringData(Integer pageSize, Integer pageNo) {
        StringBuffer sb = new StringBuffer();
        List<Future<String>> list = Lists.newArrayList();
        ExecutorService executorService = myExecutorService.getExecutorService();
        for (int i = 0; i < pageSize; i += maxSize) {
            MyCallable myCallable = new MyCallable();
            myCallable.setPageNo(i / maxSize + 1);
            myCallable.setPageSize(maxSize);
            Future<String> submit = executorService.submit(myCallable);
            list.add(submit);
        }
        for (Future<String> future : list) {
            String s = null;
            try {
                s = future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            sb.append(s).append("-");
        }
        return sb.toString();
    }
}
