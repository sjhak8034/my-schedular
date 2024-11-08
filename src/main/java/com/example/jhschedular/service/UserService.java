package com.example.jhschedular.service;

import com.example.jhschedular.dto.request.user.RequestToEditUserDto;
import com.example.jhschedular.dto.request.user.RequestToRegisterUserDto;
import com.example.jhschedular.dto.response.user.ResponseToEditUserDto;
import com.example.jhschedular.dto.response.user.ResponseToRegisterUserDto;

public interface UserService {
    ResponseToRegisterUserDto registerToDatabase(RequestToRegisterUserDto requestDto);

    ResponseToEditUserDto editUserToDatabase(RequestToEditUserDto requestDto, Long userId);
}
