package com.example.jhschedular.dto.response.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseToEditScheduleDto {
    private Long scheduleId;
    private int result;

}