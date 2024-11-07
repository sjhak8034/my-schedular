package com.example.jhschedular.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestToDeleteEntity {
    private Long scheduleId;
    private String password;
}