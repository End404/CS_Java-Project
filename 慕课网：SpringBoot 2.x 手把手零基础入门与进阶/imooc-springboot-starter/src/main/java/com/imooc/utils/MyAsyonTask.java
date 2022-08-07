

// 2-12 SpringBoot 异步任务的实现


package com.imooc.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableAsync
@Slf4j
public class MyAsyonTask {


    @Async
    public void publishMsg() {
        try {
        Thread.sleep(5000);
        log.warn("异步处理完毕");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
