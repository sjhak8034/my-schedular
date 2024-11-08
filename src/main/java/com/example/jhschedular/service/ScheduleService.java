package com.example.jhschedular.service;

import com.example.jhschedular.dto.request.schedule.RequestToDeleteScheduleDto;
import com.example.jhschedular.dto.request.schedule.RequestToEditScheduleDto;
import com.example.jhschedular.dto.request.schedule.RequestToPostScheduleDto;
import com.example.jhschedular.dto.request.schedule.RequestToSearchScheduleByDateDto;
import com.example.jhschedular.dto.request.schedule.RequestToViewScheduleDto;
import com.example.jhschedular.dto.response.schedule.ResponseToDeleteScheduleDto;
import com.example.jhschedular.dto.response.schedule.ResponseToEditScheduleDto;
import com.example.jhschedular.dto.response.schedule.ResponseToPostScheduleDto;
import com.example.jhschedular.dto.response.schedule.ResponseToSearchScheduleListDto;
import com.example.jhschedular.dto.response.schedule.ResponseToViewScheduleDto;

public interface ScheduleService {

    ResponseToPostScheduleDto saveToDatabase(RequestToPostScheduleDto requestDto, Long userId);

    ResponseToEditScheduleDto editToDatabase(RequestToEditScheduleDto requestDto, Long scheduleId);

    ResponseToSearchScheduleListDto searchToDatabaseByDate(RequestToSearchScheduleByDateDto requestDto);

    ResponseToViewScheduleDto viewToDatabase(RequestToViewScheduleDto requestDto);


    ResponseToDeleteScheduleDto deleteToDatabase(RequestToDeleteScheduleDto requestDto, Long scheduleId);


}
