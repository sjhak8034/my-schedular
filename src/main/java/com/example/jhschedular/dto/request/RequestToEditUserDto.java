package com.example.jhschedular.dto.request;

import com.example.jhschedular.entity.RequestToEditUserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestToEditUserDto {
    private String userName;
    private String email;

    public RequestToEditUserEntity toEntity(Long userId) {
        return new RequestToEditUserEntity(userId,userName,email);
    }
}