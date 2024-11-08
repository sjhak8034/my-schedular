package com.example.jhschedular.controller;


import com.example.jhschedular.dto.request.schedule.RequestToEditScheduleDto;
import com.example.jhschedular.dto.request.schedule.RequestToPostScheduleDto;
import com.example.jhschedular.dto.request.schedule.RequestToSearchScheduleByDateDto;
import com.example.jhschedular.dto.request.schedule.RequestToViewScheduleDto;
import com.example.jhschedular.dto.request.user.RequestToDeleteUserDto;
import com.example.jhschedular.dto.response.schedule.ResponseToDeleteScheduleDto;
import com.example.jhschedular.dto.response.schedule.ResponseToEditScheduleDto;
import com.example.jhschedular.dto.response.schedule.ResponseToPostScheduleDto;
import com.example.jhschedular.dto.response.schedule.ResponseToSearchScheduleListDto;
import com.example.jhschedular.dto.response.schedule.ResponseToViewScheduleDto;
import com.example.jhschedular.service.ScheduleServiceimpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
public class ScheduleController {
    private final ScheduleServiceimpl scheduleService;
    public ScheduleController(ScheduleServiceimpl scheduleService) {
        this.scheduleService = scheduleService;

    }

    @ResponseBody
    @PostMapping(value = "/schedules/users/{userId}")
    public HttpEntity<ResponseToPostScheduleDto> controllerToPost(@PathVariable("userId") Long userId,@RequestBody RequestToPostScheduleDto body) throws IOException {

        ResponseToPostScheduleDto response = scheduleService.saveToDatabase(body,userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(value = "/schedules/{scheduleId}")
    public HttpEntity<ResponseToEditScheduleDto> controllerToEditSchedule(@RequestBody RequestToEditScheduleDto body, @PathVariable("scheduleId") Long scheduleId) throws IOException {
        ResponseToEditScheduleDto response = scheduleService.editToDatabase(body,scheduleId);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @ResponseBody
    @GetMapping(value = "/schedules/users/{userId}/")
    public HttpEntity<List<ResponseToSearchScheduleListDto>> controllerToSearchScheduleListByDate(
            @RequestParam(value = "endDate",defaultValue = "9999-01-01" ) String endDate, @RequestParam(value = "startDate",defaultValue = "1000-01-01") String startDate,
            @PathVariable(value = "userId" ) Long userId , @RequestParam(value = "schedulePage") Long schedulePage,@RequestParam(value = "pageSize") Long pageSize
           ) throws IOException {

        List<ResponseToSearchScheduleListDto> response = scheduleService.searchToDatabaseByDate(new RequestToSearchScheduleByDateDto(startDate,endDate,userId,schedulePage,pageSize));

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @ResponseBody
    @GetMapping(value = "/schedules/{scheduleId}")
    public HttpEntity<Optional<ResponseToViewScheduleDto>> controllerToViewSchedule(@PathVariable("scheduleId") Long scheduleId) throws IOException {

        Optional<ResponseToViewScheduleDto> response = scheduleService.viewToDatabase(new RequestToViewScheduleDto(scheduleId)) ;

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ResponseBody
    @DeleteMapping(value = "/schedules/{scheduleId}")
    public HttpEntity<ResponseToDeleteScheduleDto> controllerToDelete(@PathVariable("scheduleId") Long scheduleId, @RequestBody RequestToDeleteUserDto body) throws IOException {
        ResponseToDeleteScheduleDto response = scheduleService.deleteToDatabase(body,scheduleId);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }


}
