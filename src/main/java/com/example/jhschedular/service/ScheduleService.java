package com.example.jhschedular.service;

import com.example.jhschedular.dto.mapper.scheduleMapper;
import com.example.jhschedular.dto.mapper.userMapper;
import com.example.jhschedular.dto.request.RequestToDeleteUserDto;
import com.example.jhschedular.dto.request.RequestToEditScheduleDto;
import com.example.jhschedular.dto.request.RequestToEditUserDto;
import com.example.jhschedular.dto.request.RequestToPostScheduleDto;
import com.example.jhschedular.dto.request.RequestToRegisterUserDto;
import com.example.jhschedular.dto.request.RequestToSearchScheduleByDateDto;
import com.example.jhschedular.dto.request.RequestToViewScheduleDto;
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

    public ResponseToPostScheduleDto saveToDatabase(RequestToPostScheduleDto requestDto, Long userId) {
        return scheduleRepository.saveSchedule(scheduleMapper.toEntity(userId,requestDto));
    }
    public ResponseToEditDto editToDatabase(RequestToEditScheduleDto requestDto, Long scheduleId ) {
        return scheduleRepository.editSchedule(scheduleMapper.toEntity(scheduleId,requestDto));
    }
    public List<ResponseToSearchScheduleListDto> searchToDatabaseByDate(RequestToSearchScheduleByDateDto requestDto) {
        Long offset = (requestDto.getSchedulePage()-1)*requestDto.getPageSize();
        return scheduleRepository.searchScheduleByDate(scheduleMapper.toEntity(requestDto),
                requestDto.getStartDate(),requestDto.getEndDate(),requestDto.getPageSize(),offset);
    }
    public Optional<ResponseToViewScheduleDto> viewToDatabase(RequestToViewScheduleDto requestDto) {
        return scheduleRepository.viewSchedule(scheduleMapper.toEntity(requestDto));
    }
    public ResponseToDeleteScheduleDto deleteToDatabase(RequestToDeleteUserDto requestDto, Long scheduleId) {
        return scheduleRepository.deleteSchedule(scheduleMapper.toEntity(requestDto,scheduleId));
    }
    public ResponseToRegisterUserDto registerToDatabase(RequestToRegisterUserDto requestDto) {
        return scheduleRepository.registerUser(userMapper.toEntity(requestDto));
    }
    public ResponseToEditUserDto editUserToDatabase(RequestToEditUserDto requestDto,Long userId) {
        return scheduleRepository.editUser(userMapper.toEntity(userId,requestDto));
    }
}
