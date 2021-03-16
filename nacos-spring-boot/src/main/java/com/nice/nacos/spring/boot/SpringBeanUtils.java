package com.nice.nacos.spring.boot;


import lombok.Data;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Create: nice
 * @Description:
 * @Date: Create in 12:26 2021/3/16
 */
@Data
public class SpringBeanUtils {
    public  static ConfigurableApplicationContext applicationContext = null;

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

}
