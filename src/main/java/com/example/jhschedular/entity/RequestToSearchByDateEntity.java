package com.example.jhschedular.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestToSearchByDateEntity {
    private String startDate;
    private String endDate;
    private String userId;
    private Long schedulePage;
    private Long pageSize;

    public Long getOffset(){
        return (schedulePage-1)*pageSize;
    }

}