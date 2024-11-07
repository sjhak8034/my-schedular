package com.example.jhschedular.dto.request;

import com.example.jhschedular.entity.RequestToSearchByDateEntity;
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
    private Long pageSize;

    public RequestToSearchByDateEntity toEntity() {
        return new RequestToSearchByDateEntity(
                this.startDate,
                this.endDate,
                this.userId,
                this.schedulePage,
                this.pageSize
        );
    }
}