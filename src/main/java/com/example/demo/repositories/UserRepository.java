package com.example.demo.repositories;

import com.example.demo.enitities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}