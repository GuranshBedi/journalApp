package net.journal.journalAPP.cache;

import jakarta.annotation.PostConstruct;
import net.journal.journalAPP.entity.ConfigJournalApp;
import net.journal.journalAPP.repository.ConfigJournalAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    public enum keys{
        WEATHER_API;
    }

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    public Map<String,String> appCache;

    @PostConstruct // This method will run after the application is run
    public void init(){
        appCache = new HashMap<>();
        List<ConfigJournalApp> all = configJournalAppRepository.findAll();
        for(ConfigJournalApp configJournalApp : all)
            appCache.put(configJournalApp.getKey(), configJournalApp.getValue());
    }
}
