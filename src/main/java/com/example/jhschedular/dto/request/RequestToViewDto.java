package com.example.jhschedular.dto.request;

import com.example.jhschedular.entity.RequestToViewEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestToViewDto {
    private Long scheduleId;

    public RequestToViewEntity toEntity() {
        return new RequestToViewEntity(
                this.scheduleId
        );
    }
}