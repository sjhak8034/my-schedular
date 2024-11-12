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
            return new Schedule.Builder().scheduleId( Optional.of(scheduleId).map(Number::longValue).get()).build();
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
        return new Schedule.Builder().scheduleId(entity.getScheduleId()).build();
    }

    /**
     * ResponseToSearchScheduleListDto 와 database 검색 결과를 연결하기 위한 메소드
     * @return RowMapper<ResponseToSearchScheduleListDto>
     */

    public RowMapper<Schedule> scheduleRowMapperForSearch(){
        return (rs, rowNum) -> new Schedule.Builder().scheduleId(
                rs.getLong("schedule_id")).title(
                rs.getString("title")).content(
                rs.getString("user_name")).postDate(
                rs.getString("post_date")).editDate(
                rs.getString("edit_date")).build();

    }

    public RowMapper<Schedule> scheduleRowMapperForView(){
        return (rs, rowNum) -> new Schedule.Builder().scheduleId(
                rs.getLong("schedule_id")).title(
                rs.getString("title")).content(
                rs.getString("content")).userName(
                rs.getString("user_name")).postDate(
                rs.getString("post_date")).editDate(
                rs.getString("edit_date")).build();

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

        return jdbcTemplate.query("select schedule_id, title, user_name,post_date,edit_date from schedules where user_id = ? and edit_date between ? and ? " +
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
        List<Schedule> result = jdbcTemplate.query("select schedule_id, title, content, user_name,post_date,edit_date from schedules where schedule_id = ?", scheduleRowMapperForView(), entity.getScheduleId());

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
        return new Schedule.Builder().scheduleId(entity.getScheduleId()).build();
    }


}
