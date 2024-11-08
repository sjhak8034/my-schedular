package com.example.jhschedular.entity;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class User {
    private static final String EMPTY_STRING = "";
    private static final Long EMPTY_USERID = 0L;
    private final Long userId;
    private final String userName;
    private final String email;
    private final String registerDate;
    private final String editDate;
    private User(Long userId, String userName, String email, String registerDate, String editDate) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.registerDate = registerDate;
        this.editDate = editDate;
    }
    private static String getCurrentFormattedDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
    public static User register(String userName, String password, String email) {
        String registerDate = getCurrentFormattedDate();
        return new User(EMPTY_USERID,userName, email,registerDate,registerDate);
    }
    public static User edit(Long userId, String userName, String email) {
        String editDate = getCurrentFormattedDate();
        return new User(userId,userName, email,EMPTY_STRING,editDate);
    }
}
