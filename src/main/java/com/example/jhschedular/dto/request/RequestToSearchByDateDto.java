package com.example.jhschedular.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestToSearchByDateDto {
    private String startDate;
    private String endDate;
    private String userId;
    private Long schedulePage;

}