package com.nice.nacos.spring.boot.dao;

/**
 * @Create: nice
 * @Description:
 * @Date: Create in 16:55 2021/3/16
 */
public interface ConfigDao {
    String queryPage(Integer pageSize, Integer pageNo);
}
