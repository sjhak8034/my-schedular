package com.example.jhschedular.controller;

import com.example.jhschedular.dto.request.user.RequestToEditUserDto;
import com.example.jhschedular.dto.request.user.RequestToRegisterUserDto;
import com.example.jhschedular.dto.response.user.ResponseToEditUserDto;
import com.example.jhschedular.dto.response.user.ResponseToRegisterUserDto;
import com.example.jhschedular.service.UserServiceImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
@RestController
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;

    }
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleResponseStatusException(ResponseStatusException ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
    }
    /**
     * 유저 등록을 위한 메소드
     * @param body 유저 등록을 위한 정보
     * @return 유저 식별자 전달
     * @throws IOException
     */
    @ResponseBody
    @PostMapping(value = "/schedules/register")
    public HttpEntity<ResponseToRegisterUserDto> controllerToRegister(@RequestBody RequestToRegisterUserDto body) throws IOException {
        ResponseToRegisterUserDto response = userService.registerToDatabase(body);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    /**
     *  유저 정보 수정을 위한 메소드
     * @param userId 유저 식별자
     * @param body 유저가 작성한 변경내용
     * @return 유저식별자 및 결과 반환
     * @throws IOException
     */
    @ResponseBody
    @PutMapping(value = "/schedules/user-profile/{userId}")
    public HttpEntity<ResponseToEditUserDto> controllerToEditUser(@PathVariable("userId") Long userId, @RequestBody RequestToEditUserDto body) throws IOException {
        ResponseToEditUserDto response = userService.editUserToDatabase(body,userId);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
