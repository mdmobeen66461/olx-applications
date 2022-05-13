package com.zensar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.UserEntity;

public interface OlxUserRepostiory extends JpaRepository<UserEntity, Integer>{
    List<UserEntity> findByUsername(String username);
}
