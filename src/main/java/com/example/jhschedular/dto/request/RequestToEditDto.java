package com.example.jhschedular.dto.request;

import com.example.jhschedular.entity.RequestToEditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestToEditDto {
    private String title;
    private String content;
    private String userName;
    private String password;

    public RequestToEditEntity toEntity(Long scheduleId) {
        return new RequestToEditEntity(scheduleId, title, content, userName, password);
    }
}