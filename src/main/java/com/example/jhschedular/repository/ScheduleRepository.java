package com.example.jhschedular.repository;

import com.example.jhschedular.dto.request.RequestToDeleteDto;
import com.example.jhschedular.dto.request.RequestToEditDto;
import com.example.jhschedular.dto.request.RequestToEditUserDto;
import com.example.jhschedular.dto.request.RequestToPostDto;
import com.example.jhschedular.dto.request.RequestToRegisterDto;
import com.example.jhschedular.dto.request.RequestToSearchByDateDto;
import com.example.jhschedular.dto.request.RequestToViewDto;
import com.example.jhschedular.dto.response.ResponseToDeleteScheduleDto;
import com.example.jhschedular.dto.response.ResponseToEditDto;
import com.example.jhschedular.dto.response.ResponseToEditUserDto;
import com.example.jhschedular.dto.response.ResponseToPostScheduleDto;
import com.example.jhschedular.dto.response.ResponseToRegisterUserDto;
import com.example.jhschedular.dto.response.ResponseToSearchScheduleListDto;
import com.example.jhschedular.dto.response.ResponseToViewScheduleDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class ScheduleRepository   {
    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public ResponseToPostScheduleDto saveSchedule(RequestToPostDto requestDto ) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate);
        simpleJdbcInsert.withTableName("schedules_v2").usingGeneratedKeyColumns("schedule_id");
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("title", requestDto.getTitle());
        params.addValue("content", requestDto.getContent());
        params.addValue("user_name", requestDto.getUserName());
        params.addValue("password", requestDto.getPassword());
        params.addValue("post_date", requestDto.getPostDate());
        params.addValue("edit_date", requestDto.getPostDate());
        params.addValue("edit_date", requestDto.getPostDate());
        params.addValue("user_id", requestDto.getUserId().get());
        try {
            Number scheduleId = simpleJdbcInsert.executeAndReturnKey(params);
            return new ResponseToPostScheduleDto( Optional.of(scheduleId).map(Number::longValue));
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public ResponseToEditDto editSchedule(RequestToEditDto requestDto ){
        int result = jdbcTemplate.update("update schedules_v2 set user_name= ?, edit_date = ?, title = ?, content = ? where schedule_id = ?",
                requestDto.getUserName(),requestDto.getEditDate(),requestDto.getTitle(), requestDto.getContent(), requestDto.getScheduleId());
        return new ResponseToEditDto(requestDto.getScheduleId(),result );
    }

    private RowMapper<ResponseToSearchScheduleListDto> scheduleRowMapperForSearch(){
        return (rs, rowNum) -> new ResponseToSearchScheduleListDto(
                rs.getLong("schedule_id"),
                rs.getString("title"),
                rs.getString("user_name"),
                rs.getString("post_date"),
                rs.getString("edit_date")
        );
    }

    public List<ResponseToSearchScheduleListDto> searchScheduleByDate(RequestToSearchByDateDto requestDto) {
        return jdbcTemplate.query("select * from schedules_v2 where user_id = ? and edit_date between ? and ? " +
                "order by schedule_id asc limit ? offset ?",new Object[]{
                requestDto.getUserId(),requestDto.getStartDate(), requestDto.getEndDate(),10,
                (requestDto.getSchedulePage()-1)*10
        }, scheduleRowMapperForSearch());
    }

    private RowMapper<ResponseToViewScheduleDto> scheduleRowMapperForView(){
        return (rs, rowNum) -> new ResponseToViewScheduleDto(
                rs.getLong("schedule_id"),
                rs.getString("title"),
                rs.getString("content"),
                rs.getString("user_name"),
                rs.getString("post_date"),
                rs.getString("edit_date")
        );
    }

    public Optional<ResponseToViewScheduleDto> viewSchedule(RequestToViewDto requestDto ){
        List<ResponseToViewScheduleDto> result = jdbcTemplate.query("select * from schedules_v2 where schedule_id = ?", scheduleRowMapperForView(), requestDto.getScheduleId());
        return result.stream().findAny();
    }

    public ResponseToDeleteScheduleDto deleteSchedule(RequestToDeleteDto requestDto ){
        return new ResponseToDeleteScheduleDto(requestDto.getScheduleId(),jdbcTemplate.update("delete from schedules_v2 where schedule_id = ? AND password = ?", requestDto.getScheduleId(), requestDto.getPassword()));
    }

    public ResponseToRegisterUserDto registerUser(RequestToRegisterDto requestDto ) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate);
        simpleJdbcInsert.withTableName("user").usingGeneratedKeyColumns("user_id");
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("user_name", requestDto.getUserName());
        params.addValue("password", requestDto.getPassword());
        params.addValue("register_date", requestDto.getRegisterDate());
        params.addValue("edit_date", requestDto.getEditDate());
        params.addValue("email", requestDto.getEmail());

        try {
            Number userId = simpleJdbcInsert.executeAndReturnKey(params);
            return new ResponseToRegisterUserDto( Optional.of(userId).map(Number::longValue));
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
            return null;
        }

    }
    public ResponseToEditUserDto editUser(RequestToEditUserDto requestDto ){
        int result = jdbcTemplate.update("update user set user_name= ?, edit_date = ?, email = ? where user_id = ?",
                requestDto.getUserName(), requestDto.getEditDate(), requestDto.getEmail(), requestDto.getUserId());
        return new ResponseToEditUserDto(requestDto.getUserId(),result );
    }
}
