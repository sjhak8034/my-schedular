package com.example.jhschedular.AppConfig;

import com.example.jhschedular.dto.request.RequestDto;
import com.example.jhschedular.repository.ScheduleRepository;

import com.example.jhschedular.service.ScheduleService;

public class AppConfig {

    public RequestDto.RequestToPostDto requestToPost(String title, String content, String userName, String password) {
        return new RequestDto.RequestToPostDto(title,content,userName,password);
    }

    public RequestDto.RequestToEditDto requestToEdit(Long scheduleId, String title, String content, String userName, String password) {
        return new RequestDto.RequestToEditDto(title,content,userName,password);
    }

    public RequestDto.RequestToDeleteDto requestToDelete(Long scheduleId, String password) {
        return new RequestDto.RequestToDeleteDto(scheduleId,password);
    }

    public RequestDto.RequestToViewDto requestToView(Long scheduleId) {
        return new RequestDto.RequestToViewDto(scheduleId);
    }

    public RequestDto.RequestToSearchDto requestToSearch(String startDate, String endDate, String userName) {
        return new RequestDto.RequestToSearchDto(startDate,endDate,userName);
    }

}
