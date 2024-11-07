package com.example.jhschedular.dto.request;

import com.example.jhschedular.entity.RequestToRegisterEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestToRegisterDto {
    private String userName;
    private String password;
    private String email;

    public RequestToRegisterEntity toEntity() {
        return new RequestToRegisterEntity(userName, password, email);
    }


}