package com.example.jhschedular.dto.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class ResponseToRegisterUserDto {
    private Optional<Long> userId;


}