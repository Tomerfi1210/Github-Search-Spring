package com.hadassah.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GitHubUserDB extends JpaRepository<GitHubUser, Long> {
    List<GitHubUser> findAll();
    boolean existsByLogin(String user_login);
    List<GitHubUser> findFirst10ByOrderBySearchCounterDesc();
    GitHubUser findByLogin(String user_login);
}
