package com.example.jhschedular.entity;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class User {
    private final Long userId;
    private final String userName;
    private final String email;
    private final String registerDate;
    private final String editDate;
    private User(Builder builder) {
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.email = builder.email;
        this.registerDate = builder.registerDate;
        this.editDate = builder.editDate;
    }
    public static class Builder {
        private Long userId;
        private String userName;
        private String email;
        private String registerDate;
        private String editDate;
        public Builder (){
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            this.registerDate = now.format(formatter);
            this.editDate = now.format(formatter);
        }
        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }
        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder registerDate(String registerDate) {
            this.registerDate = registerDate;
            return this;
        }
        public Builder editDate(String editDate) {
            this.editDate = editDate;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }
}
