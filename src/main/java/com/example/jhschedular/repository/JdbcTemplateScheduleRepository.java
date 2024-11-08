package com.example.jhschedular.repository;

import com.example.jhschedular.entity.Schedule;
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
public class JdbcTemplateScheduleRepository implements ScheduleRepository {
    private final JdbcTemplate jdbcTemplate;
    public JdbcTemplateScheduleRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * 게시글 저장을 위한 메소드
     * @param entity
     * @return ResponseToPostScheduleDto
     */
    @Override
    public Schedule saveSchedule(Schedule entity) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate);
        simpleJdbcInsert.withTableName("schedules").usingGeneratedKeyColumns("schedule_id");
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("title", entity.getTitle());
        params.addValue("content", entity.getContent());
        params.addValue("user_name", entity.getUserName());
        params.addValue("password", entity.getPassword());
        params.addValue("post_date", entity.getPostDate());
        params.addValue("edit_date", entity.getEditDate());
        params.addValue("user_id", entity.getUserId());
        try {
            Number scheduleId = simpleJdbcInsert.executeAndReturnKey(params);
            return Schedule.forScheduleId( Optional.of(scheduleId).map(Number::longValue).get());
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    /**
     *  게시글 수정을 위한 메소드
     * @param entity
     * @return ResponseToEditScheduleDto
     */
    @Override
    public Schedule editSchedule(Schedule entity){
        int result = jdbcTemplate.update("update schedules set user_name= ?, edit_date = ?, title = ?, content = ? where schedule_id = ? and password = ?",
                entity.getUserName(), entity.getEditDate(), entity.getTitle(), entity.getContent(), entity.getScheduleId(),entity.getPassword());
        if (result == 0){
            return null;
        }
        return Schedule.forScheduleId(entity.getScheduleId());
    }

    /**
     * ResponseToSearchScheduleListDto 와 database 검색 결과를 연결하기 위한 메소드
     * @return RowMapper<ResponseToSearchScheduleListDto>
     */
    @Override
    public RowMapper<Schedule> scheduleRowMapperForSearch(){
        return (rs, rowNum) -> Schedule.searchResult(
                rs.getLong("schedule_id"),
                rs.getString("title"),
                rs.getString("content"),
                rs.getString("user_name"),
                rs.getString("post_date"),
                rs.getString("edit_date")
        );
    }

    /**
     *  게시글 검색을 위한 메소드
     * @param entity
     * @param startDate
     * @param endDate
     * @param pageSize
     * @param offset 게시글 조회결과 offset 숫자만큼 무시하고 반환
     * @return List<ResponseToSearchScheduleListDto>
     */
    @Override
    public List<Schedule> searchScheduleByDate(Schedule entity, String startDate, String endDate, Long pageSize, Long offset) {

        return jdbcTemplate.query("select * from schedules where user_id = ? and edit_date between ? and ? " +
                "order by schedule_id desc limit ? offset ?",new Object[]{
                entity.getUserId(), startDate, endDate,pageSize,
                offset
        }, scheduleRowMapperForSearch());
    }



    /**
     * 게시글 조회를 위한 메소드
     * @param entity
     * @return Optional<ResponseToViewScheduleDto>
     */
    @Override
    public Optional<Schedule> viewSchedule(Schedule entity){
        List<Schedule> result = jdbcTemplate.query("select * from schedules where schedule_id = ?", scheduleRowMapperForSearch(), entity.getScheduleId());

        return result.stream().findAny();
    }

    /**
     * 게시글 삭제를 위한 메소드
     * @param entity
     * @return ResponseToDeleteScheduleDto
     */
    @Override
    public Schedule deleteSchedule(Schedule entity){
        int result = jdbcTemplate.update("delete from schedules where schedule_id = ? AND password = ?", entity.getScheduleId(), entity.getPassword());
        if (result == 0){
            return null;
        }
        return Schedule.forScheduleId(entity.getScheduleId());
    }


}
