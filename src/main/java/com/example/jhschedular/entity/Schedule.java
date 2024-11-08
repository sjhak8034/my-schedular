package com.example.jhschedular.entity;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class Schedule {
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

    private static String getCurrentFormattedDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    public static Schedule post(String title, String content, String password, String userName, Long userId) {
        String currentDate = getCurrentFormattedDate();
        return new Schedule(DEFAULT_ID, title, content, userName, password, userId, currentDate, currentDate);
    }

    public static Schedule edit(String title, String content, String password, String userName, Long scheduleId) {
        String currentDate = getCurrentFormattedDate();
        return new Schedule(scheduleId, title, content, userName, password, DEFAULT_ID, EMPTY_STRING, currentDate);
    }

    public static Schedule view(Long scheduleId) {
        return new Schedule(scheduleId, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, DEFAULT_ID, EMPTY_STRING, EMPTY_STRING);
    }

    public static Schedule search(Long userId) {
        return new Schedule(DEFAULT_ID, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, userId, EMPTY_STRING, EMPTY_STRING);
    }

    public static Schedule delete(Long scheduleId, String password) {
        return new Schedule(scheduleId, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, password, DEFAULT_ID, EMPTY_STRING, EMPTY_STRING);
    }
}
