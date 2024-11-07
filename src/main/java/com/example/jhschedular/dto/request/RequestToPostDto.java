package com.example.jhschedular.dto.request;

import com.example.jhschedular.entity.RequestToPostEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestToPostDto {
    private String title;
    private String content;
    private String password;

    public RequestToPostEntity toEntity(String userName, Optional<Long> userId) {
        return new RequestToPostEntity(title,content,password,userName,userId);
    }
}