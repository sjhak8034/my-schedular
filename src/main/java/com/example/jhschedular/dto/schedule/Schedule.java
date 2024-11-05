package com.example.jhschedular.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class Schedule {
    private String title;
    private String contents;
    private String userName;
    private String posted_date;
    private String edited_date;
    private String password;
    public Schedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }


}
