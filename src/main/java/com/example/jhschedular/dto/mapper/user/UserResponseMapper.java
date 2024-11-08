package com.example.jhschedular.dto.mapper.user;

import com.example.jhschedular.dto.response.user.ResponseToEditUserDto;
import com.example.jhschedular.dto.response.user.ResponseToRegisterUserDto;
import com.example.jhschedular.entity.User;

public class UserResponseMapper {
    public static ResponseToRegisterUserDto toRegisterUserDto(User user) {
        return new ResponseToRegisterUserDto(user.getUserId());
    }
    public static ResponseToEditUserDto toEditUserDto(User user) {
        return new ResponseToEditUserDto(user.getUserId());
    }
}
