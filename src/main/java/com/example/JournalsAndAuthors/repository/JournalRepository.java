package com.example.JournalsAndAuthors.repository;

import com.example.JournalsAndAuthors.model.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends JpaRepository<JournalEntry, Integer> {
}
