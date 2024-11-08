package com.example.jhschedular.dto.response.schedule;

import com.example.jhschedular.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseToSearchScheduleListDto {
    private List<Schedule> scheduleList;
}