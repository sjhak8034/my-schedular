package com.example.jhschedular.repository;

import com.example.jhschedular.dto.response.ResponseToDeleteScheduleDto;
import com.example.jhschedular.dto.response.ResponseToEditDto;
import com.example.jhschedular.dto.response.ResponseToEditUserDto;
import com.example.jhschedular.dto.response.ResponseToPostScheduleDto;
import com.example.jhschedular.dto.response.ResponseToRegisterUserDto;
import com.example.jhschedular.dto.response.ResponseToSearchScheduleListDto;
import com.example.jhschedular.dto.response.ResponseToViewScheduleDto;
import com.example.jhschedular.entity.RequestToDeleteEntity;
import com.example.jhschedular.entity.RequestToEditEntity;
import com.example.jhschedular.entity.RequestToEditUserEntity;
import com.example.jhschedular.entity.RequestToPostEntity;
import com.example.jhschedular.entity.RequestToRegisterEntity;
import com.example.jhschedular.entity.RequestToSearchByDateEntity;
import com.example.jhschedular.entity.RequestToViewEntity;
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
    public ResponseToPostScheduleDto saveSchedule(RequestToPostEntity entity) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate);
        simpleJdbcInsert.withTableName("schedules_v2").usingGeneratedKeyColumns("schedule_id");
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("title", entity.getTitle());
        params.addValue("content", entity.getContent());
        params.addValue("user_name", entity.getUserName());
        params.addValue("password", entity.getPassword());
        params.addValue("post_date", entity.getPostDate());
        params.addValue("edit_date", entity.getEditDate());
        params.addValue("user_id", entity.getUserId().get());
        try {
            Number scheduleId = simpleJdbcInsert.executeAndReturnKey(params);
            return new ResponseToPostScheduleDto( Optional.of(scheduleId).map(Number::longValue));
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public ResponseToEditDto editSchedule(RequestToEditEntity entity ){
        int result = jdbcTemplate.update("update schedules_v2 set user_name= ?, edit_date = ?, title = ?, content = ? where schedule_id = ? and password = ?",
                entity.getUserName(), entity.getEditDate(), entity.getTitle(), entity.getContent(), entity.getScheduleId(),entity.getPassword());
        return new ResponseToEditDto(entity.getScheduleId(),result );
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

    public List<ResponseToSearchScheduleListDto> searchScheduleByDate(RequestToSearchByDateEntity entity) {
        return jdbcTemplate.query("select * from schedules_v2 where user_id = ? and edit_date between ? and ? " +
                "order by schedule_id asc limit ? offset ?",new Object[]{
                entity.getUserId(), entity.getStartDate(), entity.getEndDate(),entity.getPageSize(),
                entity.getOffset()
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

    public Optional<ResponseToViewScheduleDto> viewSchedule(RequestToViewEntity entity ){
        List<ResponseToViewScheduleDto> result = jdbcTemplate.query("select * from schedules_v2 where schedule_id = ?", scheduleRowMapperForView(), entity.getScheduleId());
        return result.stream().findAny();
    }

    public ResponseToDeleteScheduleDto deleteSchedule(RequestToDeleteEntity entity ){
        return new ResponseToDeleteScheduleDto(entity.getScheduleId(),jdbcTemplate.update("delete from schedules_v2 where schedule_id = ? AND password = ?", entity.getScheduleId(), entity.getPassword()));
    }

    public ResponseToRegisterUserDto registerUser(RequestToRegisterEntity entity ) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate);
        simpleJdbcInsert.withTableName("user").usingGeneratedKeyColumns("user_id");
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("user_name", entity.getUserName());
        params.addValue("password", entity.getPassword());
        params.addValue("register_date", entity.getRegisterDate());
        params.addValue("edit_date", entity.getEditDate());
        params.addValue("email", entity.getEmail());

        try {
            Number userId = simpleJdbcInsert.executeAndReturnKey(params);
            return new ResponseToRegisterUserDto( Optional.of(userId).map(Number::longValue));
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
            return null;
        }

    }
    public ResponseToEditUserDto editUser(RequestToEditUserEntity entity ){
        int result = jdbcTemplate.update("update user set user_name= ?, edit_date = ?, email = ? where user_id = ?",
                entity.getUserName(), entity.getEditDate(), entity.getEmail(), entity.getUserId());
        return new ResponseToEditUserDto(entity.getUserId(),result );
    }
}
