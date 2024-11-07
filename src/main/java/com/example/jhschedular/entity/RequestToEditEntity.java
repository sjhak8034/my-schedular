package com.example.jhschedular.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class RequestToEditEntity {
    private final Long scheduleId;
    private final String title;
    private final String content;
    private final String userName;
    private final String password;
    @JsonIgnore
    private final String editDate;
    @JsonCreator
    public RequestToEditEntity(@JsonProperty("scheduleId") Long scheduleId, @JsonProperty("title") String title, @JsonProperty("content") String content, @JsonProperty("userName") String userName, @JsonProperty("password") String password) {
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