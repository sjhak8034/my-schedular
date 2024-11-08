package com.example.jhschedular.dto.request.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestToEditUserDto {
    private String userName;
    private String email;
}