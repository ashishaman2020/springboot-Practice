package com.example.JournalsAndAuthors.repository;

import com.example.JournalsAndAuthors.model.ConfigJournalAppEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigJournalAppRepository extends JpaRepository<ConfigJournalAppEntity, String> {
}
