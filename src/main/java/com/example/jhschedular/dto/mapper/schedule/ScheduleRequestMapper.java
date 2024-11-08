package com.example.jhschedular.dto.mapper.schedule;

import com.example.jhschedular.dto.request.schedule.RequestToDeleteScheduleDto;
import com.example.jhschedular.dto.request.schedule.RequestToEditScheduleDto;
import com.example.jhschedular.dto.request.schedule.RequestToPostScheduleDto;
import com.example.jhschedular.dto.request.schedule.RequestToSearchScheduleByDateDto;
import com.example.jhschedular.dto.request.schedule.RequestToViewScheduleDto;
import com.example.jhschedular.entity.Schedule;

public class ScheduleRequestMapper {
    /**
     * 게시글 삭제 메소드에 사용하는 dto entity 변환
     * @param requestToDeleteUserDto 삭제 dto
     * @param scheduleId 유저 식별자
     * @return schedule entity 반환
     */
    public static Schedule toEntity(RequestToDeleteScheduleDto requestToDeleteUserDto, Long scheduleId) {
        return Schedule.delete(scheduleId, requestToDeleteUserDto.getPassword());
    }

    /**
     *  게시글 수정 메소드에 사용하는 dto entity 변환
     * @param scheduleId 유저식별자
     * @param requestToEditScheduleDto 수정 dto
     * @return schedule entity 반환
     */
    public static Schedule toEntity(Long scheduleId, RequestToEditScheduleDto requestToEditScheduleDto) {
        return Schedule.edit(requestToEditScheduleDto.getTitle(), requestToEditScheduleDto.getContent(), requestToEditScheduleDto.getPassword(),
                requestToEditScheduleDto.getUserName(), scheduleId);
    }

    /**
     * 게시글 작성을 메소드에 사용하는 dto entity 변환
     * @param userId 유저 식별자
     * @param requestToPostScheduleDto 게시글 작성 dto
     * @return schedule entity 반환
     */
    public static Schedule toEntity(Long userId, RequestToPostScheduleDto requestToPostScheduleDto) {
        return Schedule.post(requestToPostScheduleDto.getTitle(), requestToPostScheduleDto.getContent(), requestToPostScheduleDto.getPassword(), requestToPostScheduleDto.getUserName(), userId);
    }

    /**
     * 게시글 검색 메소드에 사용하는 dto entity 변환
     * @param requestToSearchByDateDto 게시글 검색 dto
     * @return schedule entity 반환
     */
    public static Schedule toEntity(RequestToSearchScheduleByDateDto requestToSearchByDateDto) {
        return Schedule.search(requestToSearchByDateDto.getUserId());
    }

    /**
     * 게시글 조회 메소드에 사용하는 dto entity 변환
     * @param requestToViewScheduleDto 게시글 조회 dto
     * @return schedule entity 반환
     */
    public static Schedule toEntity(RequestToViewScheduleDto requestToViewScheduleDto) {
        return Schedule.view(requestToViewScheduleDto.getScheduleId());
    }
}
