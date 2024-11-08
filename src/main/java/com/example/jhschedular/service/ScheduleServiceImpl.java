package com.example.jhschedular.service;

import com.example.jhschedular.dto.mapper.scheduleMapper;
import com.example.jhschedular.dto.request.schedule.RequestToDeleteScheduleDto;
import com.example.jhschedular.dto.request.schedule.RequestToEditScheduleDto;
import com.example.jhschedular.dto.request.schedule.RequestToPostScheduleDto;
import com.example.jhschedular.dto.request.schedule.RequestToSearchScheduleByDateDto;
import com.example.jhschedular.dto.request.schedule.RequestToViewScheduleDto;
import com.example.jhschedular.dto.response.schedule.ResponseToDeleteScheduleDto;
import com.example.jhschedular.dto.response.schedule.ResponseToEditScheduleDto;
import com.example.jhschedular.dto.response.schedule.ResponseToPostScheduleDto;
import com.example.jhschedular.dto.response.schedule.ResponseToSearchScheduleListDto;
import com.example.jhschedular.dto.response.schedule.ResponseToViewScheduleDto;
import com.example.jhschedular.repository.JdbcTemplateUserRepository;
import com.example.jhschedular.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final JdbcTemplateUserRepository jdbcTemplateUserRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository, JdbcTemplateUserRepository jdbcTemplateUserRepository) {
        this.scheduleRepository = scheduleRepository;
        this.jdbcTemplateUserRepository = jdbcTemplateUserRepository;
    }

    /**
     * 일정 생성을 위한 서비스
     * @param requestDto 사용자 입력
     * @param userId 사용자 식별자
     * @return 생성된 게시글 식별자 및 성공여부 전달
     */
    @Override
    public ResponseToPostScheduleDto saveToDatabase(RequestToPostScheduleDto requestDto, Long userId) {
        return scheduleRepository.saveSchedule(scheduleMapper.toEntity(userId,requestDto));
    }

    /**
     * 게시글 정보 수정
     * @param requestDto
     * @param scheduleId
     * @return
     */
    @Override
    public ResponseToEditScheduleDto editToDatabase(RequestToEditScheduleDto requestDto, Long scheduleId ) {
        return scheduleRepository.editSchedule(scheduleMapper.toEntity(scheduleId,requestDto));
    }

    /**
     * 게시글 검색
     * @param requestDto
     * @return
     */
    @Override
    public List<ResponseToSearchScheduleListDto> searchToDatabaseByDate(RequestToSearchScheduleByDateDto requestDto) {
        Long offset = (requestDto.getSchedulePage()-1)*requestDto.getPageSize();
        return scheduleRepository.searchScheduleByDate(scheduleMapper.toEntity(requestDto),
                requestDto.getStartDate(),requestDto.getEndDate(),requestDto.getPageSize(),offset);
    }

    /**
     * 게시글 조회
     * @param requestDto
     * @return
     */
    @Override
    public Optional<ResponseToViewScheduleDto> viewToDatabase(RequestToViewScheduleDto requestDto) {
        return scheduleRepository.viewSchedule(scheduleMapper.toEntity(requestDto));
    }

    /**
     * 게시글 삭제
     * @param requestDto
     * @param scheduleId
     * @return
     */
    @Override
    public ResponseToDeleteScheduleDto deleteToDatabase(RequestToDeleteScheduleDto requestDto, Long scheduleId) {
        return scheduleRepository.deleteSchedule(scheduleMapper.toEntity(requestDto,scheduleId));
    }


}
