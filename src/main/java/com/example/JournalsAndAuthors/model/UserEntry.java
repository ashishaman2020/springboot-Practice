package com.example.JournalsAndAuthors.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userid;
    private String username;
    private String password;
    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @OneToMany
    @JoinColumn(referencedColumnName = "userid")
    private List<JournalEntry> journalEntries;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<JournalEntry> getJournalEntries() {
        return journalEntries;
    }

    public void setJournalEntries(List<JournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
    }
}
