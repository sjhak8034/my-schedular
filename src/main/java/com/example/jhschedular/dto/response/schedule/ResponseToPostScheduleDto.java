package com.example.jhschedular.dto.response.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class ResponseToPostScheduleDto {
    private Optional<Long> scheduleId;

}