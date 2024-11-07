package com.example.jhschedular.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class ResponseToRegisterUserDto {
    private Optional<Long> userId;

    public String getResponseMessage(){
        if (this.userId.isPresent()) {
            return String.format("responseMessage : userId %d registered", this.userId.get());
        }
        return String.format("responseMessage : register failed");
    }
}