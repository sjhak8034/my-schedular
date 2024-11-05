package com.example.jhschedular.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ResponseDto {
    @Data
    @AllArgsConstructor
    public static class ResponseToViewScheduleDto {
        private Long scheduleId;
        private String title;
        private String content;
        private String userName;
        private String postDate;
        private String editDate;
    }
    @Data
    @AllArgsConstructor
    public static class ResponseToEditDto {
        private Long scheduleId;
    }
    @Data
    @AllArgsConstructor
    public static class ResponseToSearchScheduleListDto {
        private Long scheduleId;
        private String title;
        private String username;
        private String postDate;
        private String editDate;
    }
    @Data
    @AllArgsConstructor
    public static class ResponseToPostScheduleDto {
        private Long scheduleId;

    }
    @Data
    @AllArgsConstructor
    public static class ResponseToDeleteScheduleDto {
        private Long scheduleId;


    }

}
