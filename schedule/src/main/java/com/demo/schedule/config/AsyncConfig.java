package com.demo.schedule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@EnableAsync
@Configuration
public class AsyncConfig {

    @Bean
    public ThreadPoolTaskScheduler syncScheduler() {
        ThreadPoolTaskScheduler syncScheduler = new ThreadPoolTaskScheduler();
        syncScheduler.setPoolSize(5);
        // 這裡給執行緒設定名字，主要是為了在專案能夠更快速的定位錯誤。
        syncScheduler.setThreadGroupName("syncTg");
        syncScheduler.setThreadNamePrefix("syncThread-");
        syncScheduler.initialize();
        return syncScheduler;
    }
}
