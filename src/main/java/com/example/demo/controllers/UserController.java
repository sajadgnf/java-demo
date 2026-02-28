package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import com.example.demo.dtos.UserDto;
import com.example.demo.enitities.User;
import com.example.demo.mappers.UserMapper;
import com.example.demo.repositories.UserRepository;

@RestController
@AllArgsConstructor
public class UserController {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @GetMapping("/users")
  @Transactional(readOnly = true)
  public List<UserDto> getAllUsers() {
    List<User> users = userRepository.findAll();
    return users.stream().map(userMapper::toDto).toList();
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
    var user = userRepository.findById(id)
        .map(userMapper::toDto)
        .orElse(null);

    if (user == null)
      return ResponseEntity.notFound().build();
    return ResponseEntity.ok(user);
  }
}
