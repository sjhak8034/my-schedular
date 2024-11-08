package com.example.jhschedular.dto.request.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestToRegisterUserDto {
    private String userName;
    private String password;
    private String email;
}