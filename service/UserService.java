package com.example.bookstore.bookstore.service;


import com.example.bookstore.bookstore.dto.UserDto;
import com.example.bookstore.bookstore.entity.User;


import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}