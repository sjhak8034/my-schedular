package com.example.jhschedular.dto.mapper;

import com.example.jhschedular.dto.request.user.RequestToEditUserDto;
import com.example.jhschedular.dto.request.user.RequestToRegisterUserDto;
import com.example.jhschedular.entity.User;

public class userMapper {
    /**
     * 유저 등록을 메소드에 사용하는 dto entity 변환
     * @param requestToRegisterUserDto 유저등록 dto
     * @return user entity 반환
     */
    public static User toEntity(RequestToRegisterUserDto requestToRegisterUserDto) {
        return User.register(requestToRegisterUserDto.getUserName(), requestToRegisterUserDto.getPassword(), requestToRegisterUserDto.getEmail());
    }

    /**
     * 유저 정보 수정 메소드에 사용하는 dto entity 변환
     * @param userId 유저 식별자
     * @param requestToEditUserDto 유저 수정 정보 dto
     * @return user entity 반환
     */
    public static User toEntity(Long userId, RequestToEditUserDto requestToEditUserDto) {
        return User.edit(userId, requestToEditUserDto.getUserName(), requestToEditUserDto.getEmail());
    }


}
