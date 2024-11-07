package com.example.jhschedular.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseToEditDto {
    private Long scheduleId;
    private int result;
    public String getResponseMessage() {
        if (result == 0){
            return String.format("responseMessage : scheduleId: %d update failed", scheduleId);
        }
        return String.format("responseMessage : scheduleId: %d updated", scheduleId);
    }
}