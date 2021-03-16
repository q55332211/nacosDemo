package com.nice.nacos.spring.boot.thread;


import com.nice.nacos.spring.boot.SpringBeanUtils;
import com.nice.nacos.spring.boot.dao.ConfigDao;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @Create: nice
 * @Description:
 * @Date: Create in 12:08 2021/3/16
 */
@Data
@Slf4j
public class MyCallable implements Callable {

    private Integer pageSize;
    private Integer pageNo;

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        ConfigDao bean = SpringBeanUtils.getBean(ConfigDao.class);
        Thread.sleep(200L);
        log.info("pageNO ->{}",pageNo);
        return bean.queryPage(pageSize, pageNo);
    }
}
