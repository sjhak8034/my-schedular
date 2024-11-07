package com.example.jhschedular.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestToDeleteDto {
    private Long scheduleId;
    private String password;
}