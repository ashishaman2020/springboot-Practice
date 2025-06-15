package com.example.JournalsAndAuthors.service;

import com.example.JournalsAndAuthors.model.UserEntry;
import com.example.JournalsAndAuthors.repository.JournalRepository;
import com.example.JournalsAndAuthors.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserEntryService {

    private final UserRepository userRepository;
    public UserEntryService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<UserEntry> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntry getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserEntry findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public void saveUserEntry(UserEntry userEntry) {
        userRepository.save(userEntry);
    }

    public void saveNewUser(UserEntry user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("User"));
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
