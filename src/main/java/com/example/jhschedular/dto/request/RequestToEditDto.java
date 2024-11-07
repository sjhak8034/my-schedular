package com.example.jhschedular.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class RequestToEditDto {
    private Long scheduleId;
    private String title;
    private String content;
    private String userName;
    private String password;
    private String editDate;
    @JsonCreator
    public RequestToEditDto(@JsonProperty("scheduleId") Long scheduleId, @JsonProperty("title") String title, @JsonProperty("content") String content, @JsonProperty("userName") String userName, @JsonProperty("password") String password) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.password = password;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.editDate = now.format(formatter);
    }
}