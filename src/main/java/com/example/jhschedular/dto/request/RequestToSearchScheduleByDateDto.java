package com.example.jhschedular.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestToSearchScheduleByDateDto {
    private String startDate;
    private String endDate;
    private Long userId;
    private Long schedulePage;
    private Long pageSize;
}