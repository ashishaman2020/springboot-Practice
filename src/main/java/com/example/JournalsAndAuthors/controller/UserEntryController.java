package com.example.JournalsAndAuthors.controller;

import com.example.JournalsAndAuthors.model.UserEntry;
import com.example.JournalsAndAuthors.response.WeatherResponse;
import com.example.JournalsAndAuthors.service.JournalEntryService;
import com.example.JournalsAndAuthors.service.UserEntryService;
import com.example.JournalsAndAuthors.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserEntryController {
    private final UserEntryService userEntryService;
    private final WeatherService weatherService;
    public UserEntryController(UserEntryService userEntryService, WeatherService weatherService) {
        this.userEntryService = userEntryService;
        this.weatherService = weatherService;
    }

    @GetMapping
    public List<UserEntry> getAllUsers() {
        return userEntryService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserEntry getUserById(@PathVariable Integer id) {
        return userEntryService.getUserById(id);
    }

    @GetMapping("/username/{username}")
    public UserEntry getUserByUsername(@PathVariable String username) {
        return userEntryService.findUserByUsername(username);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserEntry user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        UserEntry userInDb = userEntryService.findUserByUsername(username);
            userInDb.setUsername(user.getUsername());
            userInDb.setPassword(user.getPassword());
            userInDb.setRoles(user.getRoles());
            userInDb.setJournalEntries(user.getJournalEntries());
            userEntryService.saveNewUser(userInDb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userEntryService.deleteUser(id);
    }

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("Bangalore");
        return new ResponseEntity<>("Hi " + auth.getName() + ", weather feels like " + weatherResponse.getCurrent().getFeelsLike(), HttpStatus.OK);
    }
}
