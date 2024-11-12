package com.example.jhschedular.dto.mapper.user;

import com.example.jhschedular.dto.request.user.RequestToEditUserDto;
import com.example.jhschedular.dto.request.user.RequestToRegisterUserDto;
import com.example.jhschedular.entity.User;

public class UserRequestMapper {
    /**
     * 유저 등록을 메소드에 사용하는 dto entity 변환
     * @param dto 유저등록 dto
     * @return user entity 반환
     */
    public static User toEntity(RequestToRegisterUserDto dto) {
        return new User.Builder().userName(dto.getUserName()).email(dto.getEmail()).build();
    }

    /**
     * 유저 정보 수정 메소드에 사용하는 dto entity 변환
     * @param userId 유저 식별자
     * @param dto 유저 수정 정보 dto
     * @return user entity 반환
     */
    public static User toEntity(Long userId, RequestToEditUserDto dto) {
        return new User.Builder().userId(userId).userName(dto.getUserName()).email(dto.getEmail()).build();
    }


}
