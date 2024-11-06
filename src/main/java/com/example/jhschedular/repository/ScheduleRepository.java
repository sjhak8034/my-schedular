package com.example.jhschedular.repository;

import com.example.jhschedular.dto.request.RequestDto;
import com.example.jhschedular.dto.response.ResponseDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class ScheduleRepository   {
    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public ResponseDto.ResponseToPostScheduleDto saveSchedule(RequestDto.RequestToPostDto requestDto ) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate);
        simpleJdbcInsert.withTableName("schedules").usingGeneratedKeyColumns("scheduleId");
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("title", requestDto.getTitle());
        params.addValue("content", requestDto.getContent());
        params.addValue("userName", requestDto.getUserName());
        params.addValue("password", requestDto.getPassword());
        params.addValue("postDate", requestDto.getPostDate());
        params.addValue("editDate", requestDto.getPostDate());
        simpleJdbcInsert.setColumnNames(Arrays.asList("title", "content","userName","password","editDate" ,"postDate"));
        try {
            Number scheduleId = simpleJdbcInsert.executeAndReturnKey(params);
            return new ResponseDto.ResponseToPostScheduleDto( Optional.of(scheduleId).map(Number::longValue));
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public ResponseDto.ResponseToEditDto editSchedule(RequestDto.RequestToEditDto requestDto ){
        int result = jdbcTemplate.update("update schedules set userName= ?, editDate = ?, title = ?, content = ? where scheduleId = ?",
                requestDto.getUserName(),requestDto.getEditDate(),requestDto.getTitle(), requestDto.getContent(), requestDto.getScheduleId());
        return new ResponseDto.ResponseToEditDto(requestDto.getScheduleId(),result );
    }

    private RowMapper<ResponseDto.ResponseToSearchScheduleListDto> scheduleRowMapperForSearch(){
        return (rs, rowNum) -> new ResponseDto.ResponseToSearchScheduleListDto(
                rs.getLong("scheduleId"),
                rs.getString("title"),
                rs.getString("userName"),
                rs.getString("postDate"),
                rs.getString("editDate")
        );
    }

    public List<ResponseDto.ResponseToSearchScheduleListDto> searchSchedule(RequestDto.RequestToSearchDto requestDto) {
        if (requestDto.getUserName().equals("")){
            return jdbcTemplate.query("select * from schedules where editDate between ? and ?",new Object[]{requestDto.getStartDate(), requestDto.getEndDate()}, scheduleRowMapperForSearch());
        }
        return jdbcTemplate.query("select * from schedules where userName = ? and editDate between ? and ?",new Object[]{requestDto.getUserName(),requestDto.getStartDate(), requestDto.getEndDate()}, scheduleRowMapperForSearch());
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
        List<ResponseDto.ResponseToViewScheduleDto> result = jdbcTemplate.query("select * from schedules where scheduleId = ?", scheduleRowMapperForView(), requestDto.getScheduleId());
        return result.stream().findAny();
    }

    public ResponseDto.ResponseToDeleteScheduleDto deleteSchedule(RequestDto.RequestToDeleteDto requestDto ){
        return new ResponseDto.ResponseToDeleteScheduleDto(requestDto.getScheduleId(),jdbcTemplate.update("delete from schedules where scheduleId = ? AND password = ?", requestDto.getScheduleId(), requestDto.getPassword()));
    }
}
