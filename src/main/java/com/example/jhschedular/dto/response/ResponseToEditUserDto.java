package com.example.jhschedular.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseToEditUserDto {
    private Long userId;
    private int result;

}