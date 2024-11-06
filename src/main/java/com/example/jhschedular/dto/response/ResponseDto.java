package com.example.jhschedular.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

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
        private int result;
        public String getResponseMessage() {
            if (result == 0){
                return String.format("responseMessage : scheduleId: %d update failed", scheduleId);
            }
            return String.format("responseMessage : scheduleId: %d updated", scheduleId);
        }
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
        private Optional<Long> scheduleId;
        public String getResponseMessage() {
            if (scheduleId.isPresent()) {
                return String.format("responseMessage : scheduleId: %d updated", scheduleId.get());
            }
            return "responseMessage : update failed";

        }
    }
    @Data
    @AllArgsConstructor
    public static class ResponseToDeleteScheduleDto {
        private long scheduleId;
        private int result;

        public String getResponseMessage(){
            if (result == 1) {
                return String.format("responseMessage : scheduleId: %d deleted", this.scheduleId);
            }
            return String.format("responseMessage : scheduleId: %d failed", this.scheduleId);
        }


    }

}
