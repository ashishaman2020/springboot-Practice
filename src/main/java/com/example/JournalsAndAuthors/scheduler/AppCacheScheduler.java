package com.example.JournalsAndAuthors.scheduler;

import com.example.JournalsAndAuthors.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppCacheScheduler {
    @Autowired
    private AppCache appCache;

    @Scheduled(cron = "0 0/10 * 1/1 * ? *")
    public void clearAppCache() {
        appCache.init();
    }
}
