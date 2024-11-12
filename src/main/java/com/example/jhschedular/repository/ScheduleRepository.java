package com.example.jhschedular.repository;

import com.example.jhschedular.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {

    Schedule saveSchedule(Schedule entity);

    Schedule editSchedule(Schedule entity);



    List<Schedule> searchScheduleByDate(Schedule entity, String startDate, String endDate, Long pageSize, Long offset);


    Optional<Schedule> viewSchedule(Schedule entity);

    Schedule deleteSchedule(Schedule entity);
}
