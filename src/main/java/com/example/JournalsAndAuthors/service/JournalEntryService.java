package com.example.JournalsAndAuthors.service;

import com.example.JournalsAndAuthors.model.JournalEntry;
import com.example.JournalsAndAuthors.model.UserEntry;
import com.example.JournalsAndAuthors.repository.JournalRepository;
import com.example.JournalsAndAuthors.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Service
public class JournalEntryService {

    private final JournalRepository journalRepository;
    private final UserRepository userRepository;
    private final UserEntryService userEntryService;

    public JournalEntryService(JournalRepository journalRepository, UserRepository userRepository, UserEntryService userEntryService) {
        this.journalRepository = journalRepository;
        this.userRepository = userRepository;
        this.userEntryService = userEntryService;
    }

    public List<JournalEntry> getAllEntriesOfAUser(String username) {
        UserEntry user = userRepository.findUserByUsername(username);
        List<JournalEntry> getList = user.getJournalEntries();
        return getList;
    }

    public JournalEntry getEntryById(Integer id) {
        return journalRepository.findById(id).orElse(null);
    }

    @Transactional
    public void createEntry(JournalEntry journalEntry, String username) {
        UserEntry user = userEntryService.findUserByUsername(username);
        Calendar calendar = Calendar.getInstance();
        Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
        journalEntry.setDate(timestamp);
        JournalEntry saved = journalRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        userEntryService.saveUserEntry(user);
    }

    public void deleteJournalEntry(Integer id) {
        journalRepository.deleteById(id);
    }
}
