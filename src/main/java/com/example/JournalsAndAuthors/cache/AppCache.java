package com.example.JournalsAndAuthors.cache;

import com.example.JournalsAndAuthors.model.ConfigJournalAppEntity;
import com.example.JournalsAndAuthors.repository.ConfigJournalAppRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    public Map<String, String> APP_CACHE;

    @PostConstruct
    public void init() {
        APP_CACHE = new HashMap<>();
        List<ConfigJournalAppEntity> list = configJournalAppRepository.findAll();
        for(ConfigJournalAppEntity temp : list) {
            APP_CACHE.put(temp.getKey(), temp.getValue());
        }
    }
}
