package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
