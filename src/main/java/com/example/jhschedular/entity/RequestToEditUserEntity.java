package com.example.jhschedular.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class RequestToEditUserEntity {
    private Long userId;
    private String userName;
    private String email;
    private String editDate;
    @JsonCreator
    public RequestToEditUserEntity(@JsonProperty("userId") Long userId, @JsonProperty("userName") String userName
            , @JsonProperty("email") String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.editDate = now.format(formatter);

    }
}