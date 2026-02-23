package com.example.demo.controllers;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import com.example.demo.dtos.UserDto;
import com.example.demo.repositories.UserRepository;

@RestController
@AllArgsConstructor
public class UserController {
  private final UserRepository userRepository;

  @GetMapping("/users")
  @Transactional(readOnly = true)
  public List<UserDto> getAllUsers() {
    return StreamSupport.stream(userRepository.findAll().spliterator(), false)
        .map(UserDto::fromWithDetails)
        .toList();
  }
}
