package com.example.jhschedular.service;

import com.example.jhschedular.dto.request.schedule.RequestToDeleteScheduleDto;
import com.example.jhschedular.dto.request.schedule.RequestToEditScheduleDto;
import com.example.jhschedular.dto.request.schedule.RequestToPostScheduleDto;
import com.example.jhschedular.dto.request.schedule.RequestToSearchScheduleByDateDto;
import com.example.jhschedular.dto.request.schedule.RequestToViewScheduleDto;
import com.example.jhschedular.dto.request.user.RequestToEditUserDto;
import com.example.jhschedular.dto.request.user.RequestToRegisterUserDto;
import com.example.jhschedular.dto.response.schedule.ResponseToDeleteScheduleDto;
import com.example.jhschedular.dto.response.schedule.ResponseToEditScheduleDto;
import com.example.jhschedular.dto.response.schedule.ResponseToPostScheduleDto;
import com.example.jhschedular.dto.response.schedule.ResponseToSearchScheduleListDto;
import com.example.jhschedular.dto.response.schedule.ResponseToViewScheduleDto;
import com.example.jhschedular.dto.response.user.ResponseToEditUserDto;
import com.example.jhschedular.dto.response.user.ResponseToRegisterUserDto;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {

    ResponseToPostScheduleDto saveToDatabase(RequestToPostScheduleDto requestDto, Long userId);

    ResponseToEditScheduleDto editToDatabase(RequestToEditScheduleDto requestDto, Long scheduleId);

    List<ResponseToSearchScheduleListDto> searchToDatabaseByDate(RequestToSearchScheduleByDateDto requestDto);

    Optional<ResponseToViewScheduleDto> viewToDatabase(RequestToViewScheduleDto requestDto);


    ResponseToDeleteScheduleDto deleteToDatabase(RequestToDeleteScheduleDto requestDto, Long scheduleId);

    ResponseToRegisterUserDto registerToDatabase(RequestToRegisterUserDto requestDto);

    ResponseToEditUserDto editUserToDatabase(RequestToEditUserDto requestDto, Long userId);
}
