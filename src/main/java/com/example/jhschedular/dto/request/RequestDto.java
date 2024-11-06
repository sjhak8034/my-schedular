package com.example.jhschedular.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
        @JsonCreator
        public RequestToPostDto(@JsonProperty("title") String title, @JsonProperty("content") String content, @JsonProperty("userName") String userName, @JsonProperty("password") String password) {
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
        @JsonCreator
        public RequestToEditDto(@JsonProperty("scheduleId") Long scheduleId,@JsonProperty("title") String title, @JsonProperty("content") String content,  @JsonProperty("userName") String userName, @JsonProperty("password") String password) {
            this.scheduleId = scheduleId;
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
    @NoArgsConstructor
    public static class RequestToDeleteDto {
        private Long scheduleId;
        private String password;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RequestToSearchDto {
        private String startDate;
        private String endDate;
        private String userName;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RequestToViewDto {
        private Long scheduleId;
    }

}


