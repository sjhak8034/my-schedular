package com.example.jhschedular.dto.request;

import com.example.jhschedular.entity.RequestToDeleteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestToDeleteDto {
    private String password;

    public RequestToDeleteEntity toEntity(Long scheduleId) {
        return new RequestToDeleteEntity(scheduleId,this.password);
    }
}