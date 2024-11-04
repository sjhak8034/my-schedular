package com.example.jhschedular.body;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class RequestBodies {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestBodyToPost {
        private String title;
        private String content;
        private String username;
        private String password;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestBodyToEdit {
        private String title;
        private String content;
        private String username;
        private String password;
    }

}


