package com.example.jhschedular.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseToEditUserDto {
    private Long userId;
    private int result;

    public String getResponseMessage() {
        if (result == 0) {
            return String.format("responseMessage : userId: %d update failed", userId);
        }
        return String.format("responseMessage : userId: %d updated", userId);
    }
}