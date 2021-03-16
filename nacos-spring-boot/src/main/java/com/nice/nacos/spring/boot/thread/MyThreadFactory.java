package com.nice.nacos.spring.boot.thread;

import java.util.concurrent.ThreadFactory;

/**
 * @Create: nice
 * @Description:
 * @Date: Create in 11:57 2021/3/16
 */
public class MyThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "pool-" + r.hashCode());
    }
}
