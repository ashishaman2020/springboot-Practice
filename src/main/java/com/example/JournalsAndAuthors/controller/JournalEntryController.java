package com.example.JournalsAndAuthors.controller;

import com.example.JournalsAndAuthors.model.JournalEntry;
import com.example.JournalsAndAuthors.model.UserEntry;
import com.example.JournalsAndAuthors.service.JournalEntryService;
import com.example.JournalsAndAuthors.service.UserEntryService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private final JournalEntryService journalService;
    private final UserEntryService userEntryService;
    public JournalEntryController(JournalEntryService journalEntryService, UserEntryService userEntryService) {
        this.journalService = journalEntryService;
        this.userEntryService = userEntryService;
    }

    @GetMapping()
    public List<JournalEntry> getAllEntriesOfAUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return journalService.getAllEntriesOfAUser(username);
    }

    @GetMapping("/id/{id}")
    public JournalEntry getJournalEntryById(@PathVariable Integer id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        UserEntry user = userEntryService.findUserByUsername(username);
        List<JournalEntry> collect = user.getJournalEntries().stream().filter(x -> x.getJournalid().equals(id)).collect(Collectors.toList());
        if(!collect.isEmpty()) {
            JournalEntry journalEntry = journalService.getEntryById(id);
            return journalEntry;
        }
        return null;
    }

    @PostMapping("/create")
    public void createEntry(@RequestBody JournalEntry journalEntry) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        journalService.createEntry(journalEntry, username);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteJournalEntry(@PathVariable Integer id) {
        journalService.deleteJournalEntry(id);
    }
}
