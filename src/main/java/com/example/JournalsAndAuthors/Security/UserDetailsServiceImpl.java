package com.example.JournalsAndAuthors.Security;

import com.example.JournalsAndAuthors.model.UserEntry;
import com.example.JournalsAndAuthors.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntry userByUsername = userRepository.findUserByUsername(username);
        if(userByUsername != null) {
           return User.builder()
                    .username(userByUsername.getUsername())
                    .password(userByUsername.getPassword())
                    .roles(userByUsername.getRoles().toArray(new String[0]))
                    .build();
        }
        throw new UsernameNotFoundException("username was not found");
    }
}
