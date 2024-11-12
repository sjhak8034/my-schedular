package com.example.jhschedular.dto.mapper.schedule;

import com.example.jhschedular.dto.request.schedule.RequestToDeleteScheduleDto;
import com.example.jhschedular.dto.request.schedule.RequestToEditScheduleDto;
import com.example.jhschedular.dto.request.schedule.RequestToPostScheduleDto;
import com.example.jhschedular.dto.request.schedule.RequestToSearchScheduleByDateDto;
import com.example.jhschedular.dto.request.schedule.RequestToViewScheduleDto;
import com.example.jhschedular.entity.Schedule;

// builder를 사용한 버전
public class ScheduleRequestMapper {
    public static Schedule toEntity(RequestToDeleteScheduleDto dto, Long scheduleId) {
        return new Schedule.Builder().password(dto.getPassword()).scheduleId(scheduleId).build();
    }

    /**
     * 게시글 수정 메소드에 사용하는 dto entity 변환
     *
     * @param scheduleId 유저식별자
     * @param dto        수정 dto
     * @return schedule entity 반환
     */
    public static Schedule toEntity(Long scheduleId, RequestToEditScheduleDto dto) {
        return new Schedule.Builder().title(dto.getTitle()).content(dto.getContent()).password(dto.getPassword()).userName(dto.getUserName()).scheduleId(scheduleId).build();
    }

    /**
     * 게시글 작성을 메소드에 사용하는 dto entity 변환
     *
     * @param userId 유저 식별자
     * @param dto    게시글 작성 dto
     * @return schedule entity 반환
     */
    public static Schedule toEntity(Long userId, RequestToPostScheduleDto dto) {
        return new Schedule.Builder().title(dto.getTitle()).content(dto.getContent()).password(dto.getPassword()).userName(dto.getUserName()).userId(userId).build();
    }

    /**
     * 게시글 검색 메소드에 사용하는 dto entity 변환
     *
     * @param dto 게시글 검색 dto
     * @return schedule entity 반환
     */
    public static Schedule toEntity(RequestToSearchScheduleByDateDto dto) {
        return new Schedule.Builder().userId(dto.getUserId()).build();
    }

    /**
     * 게시글 조회 메소드에 사용하는 dto entity 변환
     *
     * @param dto 게시글 조회 dto
     * @return schedule entity 반환
     */
    public static Schedule toEntity(RequestToViewScheduleDto dto) {
        return new Schedule.Builder().scheduleId(dto.getScheduleId()).build();
    }
}
