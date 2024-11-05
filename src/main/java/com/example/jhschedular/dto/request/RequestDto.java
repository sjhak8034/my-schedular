package com.example.jhschedular.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RequestDto {
    @Data
    public static class RequestToPostDto {
        private String title;
        private String content;
        private String userName;
        private String password;
        private String postDate;

        public RequestToPostDto(String title, String content, String userName, String password) {
            this.title = title;
            this.content = content;
            this.userName = userName;
            this.password = password;
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            this.postDate = now.format(formatter);
        }

    }

    @Data

    public static class RequestToEditDto {
        private Long scheduleId;
        private String title;
        private String content;
        private String userName;
        private String password;
        private String editDate;
        public RequestToEditDto(String title, String content, String userName, String password) {
            this.title = title;
            this.content = content;
            this.userName = userName;
            this.password = password;
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            this.editDate = now.format(formatter);
        }
    }

    @Data
    @AllArgsConstructor
    public static class RequestToDeleteDto {
        private Long scheduleId;
        private String password;
    }

    @Data
    @AllArgsConstructor
    public static class RequestToSearchDto {
        private String startDate;
        private String endDate;
        private String userName;
    }

    @Data
    @AllArgsConstructor
    public static class RequestToViewDto {
        private Long scheduleId;
    }

}


