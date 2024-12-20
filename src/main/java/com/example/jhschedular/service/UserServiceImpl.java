package com.example.jhschedular.service;

import com.example.jhschedular.dto.mapper.user.UserRequestMapper;
import com.example.jhschedular.dto.mapper.user.UserResponseMapper;
import com.example.jhschedular.dto.request.user.RequestToEditUserDto;
import com.example.jhschedular.dto.request.user.RequestToRegisterUserDto;
import com.example.jhschedular.dto.response.user.ResponseToEditUserDto;
import com.example.jhschedular.dto.response.user.ResponseToRegisterUserDto;
import com.example.jhschedular.entity.User;
import com.example.jhschedular.repository.JdbcTemplateUserRepository;
import com.example.jhschedular.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        User entity = jdbcTemplateUserRepository.registerUser(UserRequestMapper.toEntity(requestDto));
        if(entity == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "작성 실패");
        }
        return UserResponseMapper.toRegisterUserDto(entity) ;
    }

    /**
     * 유저 정보 수정
     * @param requestDto
     * @param userId
     * @return
     */
    @Override
    public ResponseToEditUserDto editUserToDatabase(RequestToEditUserDto requestDto, Long userId) {
        User entity = jdbcTemplateUserRepository.editUser(UserRequestMapper.toEntity(userId,requestDto));
        if(entity == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "수정 실패");
        }
        return UserResponseMapper.toEditUserDto(entity);
    }
}
