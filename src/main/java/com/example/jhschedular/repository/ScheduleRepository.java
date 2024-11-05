package com.example.jhschedular.repository;

import com.example.jhschedular.dto.request.RequestDto;
import com.example.jhschedular.dto.response.ResponseDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ScheduleRepository   {
    private final JdbcTemplate jdbcTemplate;
    public ScheduleRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public ResponseDto.ResponseToPostScheduleDto saveSchedule(RequestDto.RequestToPostDto requestDto ) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate);
        simpleJdbcInsert.withTableName("schedules").usingGeneratedKeyColumns("schedule_id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", requestDto.getTitle());
        parameters.put("content", requestDto.getContent());
        parameters.put("user_name", requestDto.getUserName());
        parameters.put("password", requestDto.getPassword());
        parameters.put("post_date", requestDto.getPostDate());
        parameters.put("edit_date", requestDto.getPostDate());
        Number scheduleId = simpleJdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        return new ResponseDto.ResponseToPostScheduleDto(scheduleId.longValue());
    }
    public ResponseDto.ResponseToEditDto editSchedule(RequestDto.RequestToEditDto requestDto ){
        jdbcTemplate.update("update schedules set userName, editDate = ?, title = ?, content = ? where id = ?",
                requestDto.getUserName(),requestDto.getEditDate(),requestDto.getTitle(), requestDto.getContent(), requestDto.getScheduleId());
        return new ResponseDto.ResponseToEditDto(requestDto.getScheduleId());
    }
    public ResponseDto.ResponseToDeleteScheduleDto DeleteSchedule(RequestDto.RequestToDeleteDto requestDto ){
        jdbcTemplate.update("delete from schedules where scheduleId = ?", requestDto.getScheduleId());
        return new ResponseDto.ResponseToDeleteScheduleDto(requestDto.getScheduleId());
    }
    private RowMapper<ResponseDto.ResponseToSearchScheduleListDto> scheduleRowMapperForSearch(){
        return (rs, rowNum) -> new ResponseDto.ResponseToSearchScheduleListDto(
                rs.getLong("scheduleId"),
                rs.getString("title"),
                rs.getString("userName"),
                rs.getString("postDate"),
                rs.getString("EditDate")
        );
    }
    public List<ResponseDto.ResponseToSearchScheduleListDto> searchSchedule(RequestDto.RequestToSearchDto requestDto) {
        if (requestDto.getUserName() == null){
            return jdbcTemplate.query("select * from schedules where editDate between ? and ?",new Object[]{requestDto.getStartDate(), requestDto.getEndDate()}, scheduleRowMapperForSearch());
        }
        return jdbcTemplate.query("select * from schedules where userName = ? and editDate between ? and ?",new Object[]{requestDto.getUserName(),requestDto.getStartDate(), requestDto.getEndDate()}, scheduleRowMapperForSearch());
    }
    public List<ResponseDto.ResponseToSearchScheduleListDto> searchAllSchedule() {
        return jdbcTemplate.query("select * from schedules", scheduleRowMapperForSearch());
    }
    private RowMapper<ResponseDto.ResponseToViewScheduleDto> scheduleRowMapperForView(){
        return (rs, rowNum) -> new ResponseDto.ResponseToViewScheduleDto(
                rs.getLong("scheduleId"),
                rs.getString("title"),
                rs.getString("content"),
                rs.getString("userName"),
                rs.getString("postDate"),
                rs.getString("EditDate")
        );
    }

    public Optional<ResponseDto.ResponseToViewScheduleDto> viewSchedule(RequestDto.RequestToViewDto requestDto ){
        List<ResponseDto.ResponseToViewScheduleDto> result = jdbcTemplate.query("select * from memo where id = ?", scheduleRowMapperForView(), requestDto.getScheduleId());
        return result.stream().findAny();
    }
    public ResponseDto.ResponseToDeleteScheduleDto deleteSchedule(RequestDto.RequestToDeleteDto requestDto ){
        jdbcTemplate.update("delete from schedules where scheduleId = ?", requestDto.getScheduleId());
        return new ResponseDto.ResponseToDeleteScheduleDto(requestDto.getScheduleId());
    }
}
