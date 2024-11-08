package com.example.jhschedular.controller;

import com.example.jhschedular.dto.request.user.RequestToEditUserDto;
import com.example.jhschedular.dto.request.user.RequestToRegisterUserDto;
import com.example.jhschedular.dto.response.user.ResponseToEditUserDto;
import com.example.jhschedular.dto.response.user.ResponseToRegisterUserDto;
import com.example.jhschedular.service.ScheduleServiceimpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
@RestController
public class UserController {
    private final ScheduleServiceimpl scheduleService;
    public UserController(ScheduleServiceimpl scheduleService) {
        this.scheduleService = scheduleService;

    }
    @ResponseBody
    @PostMapping(value = "/schedules/register")
    public HttpEntity<ResponseToRegisterUserDto> controllerToRegister(@RequestBody RequestToRegisterUserDto body) throws IOException {
        ResponseToRegisterUserDto response = scheduleService.registerToDatabase(body);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    @ResponseBody
    @PutMapping(value = "/schedules/user-profile/{userId}")
    public HttpEntity<ResponseToEditUserDto> controllerToEditUser(@PathVariable("userId") Long userId, @RequestBody RequestToEditUserDto body) throws IOException {
        ResponseToEditUserDto response = scheduleService.editUserToDatabase(body,userId);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
