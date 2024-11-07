package com.example.jhschedular.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseToViewScheduleDto {
    private Long scheduleId;
    private String title;
    private String content;
    private String userName;
    private String postDate;
    private String editDate;
}
