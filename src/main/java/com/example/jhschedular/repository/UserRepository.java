package com.example.jhschedular.repository;

import com.example.jhschedular.dto.response.user.ResponseToEditUserDto;
import com.example.jhschedular.dto.response.user.ResponseToRegisterUserDto;
import com.example.jhschedular.entity.User;

public interface UserRepository {
    ResponseToRegisterUserDto registerUser(User entity);

    ResponseToEditUserDto editUser(User entity);
}
