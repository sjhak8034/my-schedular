package com.example.jhschedular.dto.mapper;

import com.example.jhschedular.dto.request.RequestToDeleteUserDto;
import com.example.jhschedular.dto.request.RequestToEditScheduleDto;
import com.example.jhschedular.dto.request.RequestToPostScheduleDto;
import com.example.jhschedular.dto.request.RequestToSearchScheduleByDateDto;
import com.example.jhschedular.dto.request.RequestToViewScheduleDto;
import com.example.jhschedular.entity.Schedule;

public class scheduleMapper {
    public static Schedule toEntity(RequestToDeleteUserDto requestToDeleteUserDto, Long scheduleId) {
        return Schedule.delete(scheduleId, requestToDeleteUserDto.getPassword());
    }

    public static Schedule toEntity(Long scheduleId, RequestToEditScheduleDto requestToEditScheduleDto) {
        return Schedule.edit(requestToEditScheduleDto.getTitle(), requestToEditScheduleDto.getContent(), requestToEditScheduleDto.getPassword(),
                requestToEditScheduleDto.getUserName(), scheduleId);
    }

    public static Schedule toEntity(Long userId, RequestToPostScheduleDto requestToPostScheduleDto) {
        return Schedule.post(requestToPostScheduleDto.getTitle(), requestToPostScheduleDto.getContent(), requestToPostScheduleDto.getPassword(), requestToPostScheduleDto.getUserName(), userId);
    }

    public static Schedule toEntity(RequestToSearchScheduleByDateDto requestToSearchByDateDto) {
        return Schedule.search(requestToSearchByDateDto.getUserId());
    }

    public static Schedule toEntity(RequestToViewScheduleDto requestToViewScheduleDto) {
        return Schedule.view(requestToViewScheduleDto.getScheduleId());
    }
}
