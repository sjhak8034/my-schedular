package com.example.jhschedular.entity;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class Schedule {

    private final Long scheduleId;
    private final String title;
    private final String content;
    private final String userName;
    private final String password;
    private final Long userId;
    private final String postDate;
    private final String editDate;
    private Schedule(Builder builder) {
        this.scheduleId = builder.scheduleId;
        this.title = builder.title;
        this.content = builder.content;
        this.userName = builder.userName;
        this.password = builder.password;
        this.userId = builder.userId;
        this.postDate = builder.postDate;
        this.editDate = builder.editDate;
    }
    public static class Builder {
        private  Long scheduleId;
        private  String title;
        private  String content;
        private  String userName;
        private  String password;
        private  Long userId;
        private  String postDate;
        private  String editDate;

        public Builder() {
            this.postDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            this.editDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }

        public Builder scheduleId(Long scheduleId) {
            this.scheduleId = scheduleId;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }
        public Schedule.Builder postDate(String registerDate) {
            this.postDate = registerDate;
            return this;
        }
        public Schedule.Builder editDate(String editDate) {
            this.editDate = editDate;
            return this;
        }
        public Schedule build() {
            return new Schedule(this);
        }
    }
}
