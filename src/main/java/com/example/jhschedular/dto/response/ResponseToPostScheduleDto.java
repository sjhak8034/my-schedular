package com.example.jhschedular.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class ResponseToPostScheduleDto {
    private Optional<Long> scheduleId;
    public String getResponseMessage() {
        if (scheduleId.isPresent()) {
            return String.format("responseMessage : scheduleId: %d updated", scheduleId.get());
        }
        return "responseMessage : update failed";

    }
}