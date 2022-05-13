package com.zensar.olxmaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olxmaster.entity.UserEntity;
public interface UserRepostiory extends JpaRepository<UserEntity, Integer>{
    List<UserEntity> findByUsername(String username);
}
