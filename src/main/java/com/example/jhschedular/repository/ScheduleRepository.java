package com.example.jhschedular.repository;

import com.example.jhschedular.dto.response.schedule.ResponseToDeleteScheduleDto;
import com.example.jhschedular.dto.response.schedule.ResponseToEditScheduleDto;
import com.example.jhschedular.dto.response.schedule.ResponseToPostScheduleDto;
import com.example.jhschedular.dto.response.schedule.ResponseToSearchScheduleListDto;
import com.example.jhschedular.dto.response.schedule.ResponseToViewScheduleDto;
import com.example.jhschedular.entity.Schedule;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {

    ResponseToPostScheduleDto saveSchedule(Schedule entity);

    ResponseToEditScheduleDto editSchedule(Schedule entity);

    RowMapper<ResponseToSearchScheduleListDto> scheduleRowMapperForSearch();

    List<ResponseToSearchScheduleListDto> searchScheduleByDate(Schedule entity, String startDate, String endDate, Long pageSize, Long offset);

    RowMapper<ResponseToViewScheduleDto> scheduleRowMapperForView();

    Optional<ResponseToViewScheduleDto> viewSchedule(Schedule entity);

    ResponseToDeleteScheduleDto deleteSchedule(Schedule entity);
}
