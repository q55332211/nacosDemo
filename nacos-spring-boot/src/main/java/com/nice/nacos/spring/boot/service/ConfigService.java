package com.nice.nacos.spring.boot.service;

/**
 * @Create: nice
 * @Description:
 * @Date: Create in 12:14 2021/3/16
 */
public interface ConfigService {

    String getStringData(Integer pageSize,Integer pageNo) throws InterruptedException;
}
