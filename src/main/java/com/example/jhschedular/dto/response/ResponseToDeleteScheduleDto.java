package com.example.jhschedular.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseToDeleteScheduleDto {
    private long scheduleId;
    private int result;

    public String getResponseMessage(){
        if (result == 1) {
            return String.format("responseMessage : scheduleId: %d deleted", this.scheduleId);
        }
        return String.format("responseMessage : scheduleId: %d failed", this.scheduleId);
    }


}