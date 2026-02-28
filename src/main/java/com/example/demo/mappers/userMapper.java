package com.example.demo.mappers;

import com.example.demo.dtos.UserDto;
import com.example.demo.enitities.User;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserDto toDto(User user);
}
