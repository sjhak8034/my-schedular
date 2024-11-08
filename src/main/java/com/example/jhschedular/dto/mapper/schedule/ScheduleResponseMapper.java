package com.example.jhschedular.dto.mapper.schedule;

import com.example.jhschedular.dto.response.schedule.ResponseToDeleteScheduleDto;
import com.example.jhschedular.dto.response.schedule.ResponseToEditScheduleDto;
import com.example.jhschedular.dto.response.schedule.ResponseToPostScheduleDto;
import com.example.jhschedular.dto.response.schedule.ResponseToSearchScheduleListDto;
import com.example.jhschedular.dto.response.schedule.ResponseToViewScheduleDto;
import com.example.jhschedular.entity.Schedule;

import java.util.List;

public class ScheduleResponseMapper {
    public static ResponseToPostScheduleDto toPostDto(Schedule schedule) {
        return new ResponseToPostScheduleDto(schedule.getScheduleId());
    }
    public static ResponseToEditScheduleDto toEditDto(Schedule schedule) {
        return new ResponseToEditScheduleDto(schedule.getScheduleId());
    }
    public static ResponseToDeleteScheduleDto toDeleteDto(Schedule schedule) {
        return new ResponseToDeleteScheduleDto(schedule.getScheduleId());
    }
    public static ResponseToSearchScheduleListDto toSearchDto(List<Schedule> schedules) {
        return new ResponseToSearchScheduleListDto(schedules);
    }
    public static ResponseToViewScheduleDto toViewDto(Schedule schedule) {
        return new ResponseToViewScheduleDto(schedule.getScheduleId(),schedule.getTitle(),schedule.getContent(),schedule.getUserName(),schedule.getPostDate(),schedule.getEditDate());
    }
}
