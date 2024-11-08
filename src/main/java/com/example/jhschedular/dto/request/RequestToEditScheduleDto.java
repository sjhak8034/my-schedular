package com.example.jhschedular.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestToEditScheduleDto {
    private String title;
    private String content;
    private String userName;
    private String password;
}