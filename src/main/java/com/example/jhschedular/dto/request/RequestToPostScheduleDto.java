package com.example.jhschedular.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestToPostScheduleDto {
    private String title;
    private String content;
    private String password;
    private String userName;
}