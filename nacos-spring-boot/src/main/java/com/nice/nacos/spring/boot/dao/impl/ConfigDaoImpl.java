package com.nice.nacos.spring.boot.dao.impl;


import com.nice.nacos.spring.boot.dao.ConfigDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @Create: nice
 * @Description:
 * @Date: Create in 16:56 2021/3/16
 */
@Repository
@Slf4j
public class ConfigDaoImpl implements ConfigDao {

    @Override
    public String queryPage(Integer pageSize, Integer pageNo) {
        return String.valueOf(pageNo * pageSize);
    }
}
