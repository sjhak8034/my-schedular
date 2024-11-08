package com.example.jhschedular.dto.mapper;

import com.example.jhschedular.dto.request.RequestToEditUserDto;
import com.example.jhschedular.dto.request.RequestToRegisterUserDto;
import com.example.jhschedular.entity.User;

public class userMapper {
    public static User toEntity(RequestToRegisterUserDto requestToRegisterUserDto) {
        return User.register(requestToRegisterUserDto.getUserName(), requestToRegisterUserDto.getPassword(), requestToRegisterUserDto.getEmail());
    }
    public static User toEntity(Long userId, RequestToEditUserDto requestToEditUserDto) {
        return User.edit(userId, requestToEditUserDto.getUserName(), requestToEditUserDto.getEmail());
    }


}
