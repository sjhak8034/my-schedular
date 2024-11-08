package com.example.jhschedular.service;

import com.example.jhschedular.dto.mapper.userMapper;
import com.example.jhschedular.dto.request.user.RequestToEditUserDto;
import com.example.jhschedular.dto.request.user.RequestToRegisterUserDto;
import com.example.jhschedular.dto.response.user.ResponseToEditUserDto;
import com.example.jhschedular.dto.response.user.ResponseToRegisterUserDto;
import com.example.jhschedular.repository.JdbcTemplateUserRepository;
import com.example.jhschedular.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JdbcTemplateUserRepository jdbcTemplateUserRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, JdbcTemplateUserRepository jdbcTemplateUserRepository) {
        this.userRepository = userRepository;
        this.jdbcTemplateUserRepository = jdbcTemplateUserRepository;
    }
    /**
     * 유저 등록
     * @param requestDto
     * @return
     */
    @Override
    public ResponseToRegisterUserDto registerToDatabase(RequestToRegisterUserDto requestDto) {
        return jdbcTemplateUserRepository.registerUser(userMapper.toEntity(requestDto));
    }

    /**
     * 유저 정보 수정
     * @param requestDto
     * @param userId
     * @return
     */
    @Override
    public ResponseToEditUserDto editUserToDatabase(RequestToEditUserDto requestDto, Long userId) {
        return jdbcTemplateUserRepository.editUser(userMapper.toEntity(userId,requestDto));
    }
}
