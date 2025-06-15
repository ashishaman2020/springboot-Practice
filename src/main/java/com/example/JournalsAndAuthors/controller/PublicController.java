package com.example.JournalsAndAuthors.controller;

import com.example.JournalsAndAuthors.model.UserEntry;
import com.example.JournalsAndAuthors.service.UserEntryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {
    private final UserEntryService userEntryService;
    public PublicController(UserEntryService userEntryService) {
        this.userEntryService = userEntryService;
    }

    @PostMapping("/save")
    public void saveUserEntry(@RequestBody UserEntry userEntry) {
        userEntryService.saveNewUser(userEntry);
    }
}
