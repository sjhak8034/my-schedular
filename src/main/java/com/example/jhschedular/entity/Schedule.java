package com.example.jhschedular.entity;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class Schedule {
    // 사용하지 않는 변수를 채우기위한 값
    private static final Long DEFAULT_ID = 0L;
    private static final String EMPTY_STRING = "";

    private final Long scheduleId;
    private final String title;
    private final String content;
    private final String userName;
    private final String password;
    private final Long userId;
    private final String postDate;
    private final String editDate;

    // private 생성자
    private Schedule(Long scheduleId, String title, String content, String userName, String password, Long userId, String postDate, String editDate) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.password = password;
        this.userId = userId;
        this.postDate = postDate;
        this.editDate = editDate;
    }
    // 정적 팩토리 메소드

    /**
     * 현재 날짜와 시간을 얻기위한 메소드
     * @return 현재 날짜 시간 반환
     */
    private static String getCurrentFormattedDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    /**
     * 업로드 entity
     * @param title
     * @param content
     * @param password
     * @param userName
     * @param userId
     * @return
     */
    public static Schedule post(String title, String content, String password, String userName, Long userId) {
        String currentDate = getCurrentFormattedDate();
        return new Schedule(DEFAULT_ID, title, content, userName, password, userId, currentDate, currentDate);
    }

    /**
     * 수정 entity
     * @param title
     * @param content
     * @param password
     * @param userName
     * @param scheduleId
     * @return
     */
    public static Schedule edit(String title, String content, String password, String userName, Long scheduleId) {
        String currentDate = getCurrentFormattedDate();
        return new Schedule(scheduleId, title, content, userName, password, DEFAULT_ID, EMPTY_STRING, currentDate);
    }

    /**
     * 조회 entity
     * @param scheduleId
     * @return
     */
    public static Schedule view(Long scheduleId) {
        return new Schedule(scheduleId, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, DEFAULT_ID, EMPTY_STRING, EMPTY_STRING);
    }

    /**
     * 검색 entity
     * @param userId
     * @return
     */
    public static Schedule search(Long userId) {
        return new Schedule(DEFAULT_ID, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, userId, EMPTY_STRING, EMPTY_STRING);
    }

    /**
     * 삭제 entity
     * @param scheduleId
     * @param password
     * @return
     */
    public static Schedule delete(Long scheduleId, String password) {
        return new Schedule(scheduleId, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, password, DEFAULT_ID, EMPTY_STRING, EMPTY_STRING);
    }
}
