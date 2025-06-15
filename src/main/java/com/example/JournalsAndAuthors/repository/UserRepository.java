package com.example.JournalsAndAuthors.repository;

import com.example.JournalsAndAuthors.model.UserEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntry, Integer> {
    @Query("SELECT user FROM UserEntry user WHERE username=:username")
    UserEntry findUserByUsername(@Param(value = "username") String username);
}
