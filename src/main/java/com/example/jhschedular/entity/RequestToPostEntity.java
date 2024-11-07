package com.example.jhschedular.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
@Setter
public class RequestToPostEntity {
    private String title;
    private String content;
    private String userName;
    private String password;
    private Optional<Long> userId;
    @JsonIgnore
    private String postDate;
    @JsonIgnore
    private String editDate;
    @JsonCreator
    public RequestToPostEntity(@JsonProperty("title") String title, @JsonProperty("content") String content,  @JsonProperty("password") String password
    , @JsonProperty("userName") String userName, @JsonProperty("userId") Optional<Long> userId) {
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.password = password;
        this.userId = userId;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.postDate = now.format(formatter);
        this.editDate = now.format(formatter);
    }

}