package com.example.jhschedular.service;

import com.example.jhschedular.dto.request.RequestToDeleteDto;
import com.example.jhschedular.dto.request.RequestToEditDto;
import com.example.jhschedular.dto.request.RequestToEditUserDto;
import com.example.jhschedular.dto.request.RequestToPostDto;
import com.example.jhschedular.dto.request.RequestToRegisterDto;
import com.example.jhschedular.dto.request.RequestToSearchByDateDto;
import com.example.jhschedular.dto.request.RequestToViewDto;
import com.example.jhschedular.dto.response.ResponseToDeleteScheduleDto;
import com.example.jhschedular.dto.response.ResponseToEditDto;
import com.example.jhschedular.dto.response.ResponseToEditUserDto;
import com.example.jhschedular.dto.response.ResponseToPostScheduleDto;
import com.example.jhschedular.dto.response.ResponseToRegisterUserDto;
import com.example.jhschedular.dto.response.ResponseToSearchScheduleListDto;
import com.example.jhschedular.dto.response.ResponseToViewScheduleDto;
import com.example.jhschedular.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ResponseToPostScheduleDto saveToDatabase(RequestToPostDto requestDto, String userName, Optional<Long> userId) {
        return scheduleRepository.saveSchedule(requestDto.toEntity(userName,userId));
    }
    public ResponseToEditDto editToDatabase(RequestToEditDto requestDto,Long scheduleId ) {
        return scheduleRepository.editSchedule(requestDto.toEntity(scheduleId));
    }
    public List<ResponseToSearchScheduleListDto> searchToDatabaseByDate(RequestToSearchByDateDto requestDto) {
        return scheduleRepository.searchScheduleByDate(requestDto.toEntity());
    }
    public Optional<ResponseToViewScheduleDto> viewToDatabase(RequestToViewDto requestDto) {
        return scheduleRepository.viewSchedule(requestDto.toEntity());
    }
    public ResponseToDeleteScheduleDto deleteToDatabase(RequestToDeleteDto requestDto,Long scheduleId) {
        return scheduleRepository.deleteSchedule(requestDto.toEntity(scheduleId));
    }
    public ResponseToRegisterUserDto registerToDatabase(RequestToRegisterDto requestDto) {
        return scheduleRepository.registerUser(requestDto.toEntity());
    }
    public ResponseToEditUserDto editUserToDatabase(RequestToEditUserDto requestDto,Long userId) {
        return scheduleRepository.editUser(requestDto.toEntity(userId));
    }
}
