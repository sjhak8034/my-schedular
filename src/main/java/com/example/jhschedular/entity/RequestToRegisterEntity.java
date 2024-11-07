package com.example.jhschedular.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class RequestToRegisterEntity {
    private String userName;
    private String password;
    private String email;
    private String registerDate;
    private String editDate;
    @JsonCreator
    public RequestToRegisterEntity(@JsonProperty("userName") String userName, @JsonProperty("password") String password
            , @JsonProperty("email") String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.registerDate = now.format(formatter);
        this.editDate = this.registerDate;
    }
}