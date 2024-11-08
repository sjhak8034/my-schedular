package com.example.jhschedular.dto.response.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseToSearchScheduleListDto {
    private Long scheduleId;
    private String title;
    private String username;
    private String postDate;
    private String editDate;
}