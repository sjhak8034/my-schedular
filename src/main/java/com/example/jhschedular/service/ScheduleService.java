package com.example.jhschedular.service;

import com.example.jhschedular.dto.request.RequestDto;
import com.example.jhschedular.dto.response.ResponseDto;
import com.example.jhschedular.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ResponseDto.ResponseToPostScheduleDto saveToDatabase(RequestDto.RequestToPostDto requestDto) {
        return scheduleRepository.saveSchedule(requestDto);
    }
    public ResponseDto.ResponseToEditDto editToDatabase(RequestDto.RequestToEditDto requestDto) {
        return scheduleRepository.editSchedule(requestDto);
    }
    public List<ResponseDto.ResponseToSearchScheduleListDto> searchToDatabase(RequestDto.RequestToSearchDto requestDto) {
        if(requestDto.getStartDate() == null || requestDto.getEndDate() == null) {
            return scheduleRepository.searchAllSchedule();
        }
        return scheduleRepository.searchSchedule(requestDto);

    }
    public Optional<ResponseDto.ResponseToViewScheduleDto> viewToDatabase(RequestDto.RequestToViewDto requestDto) {
        return scheduleRepository.viewSchedule(requestDto);
    }
    public ResponseDto.ResponseToDeleteScheduleDto deleteToDatabase(RequestDto.RequestToDeleteDto requestDto) {
        return scheduleRepository.deleteSchedule(requestDto);
    }
}
