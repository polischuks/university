package com.polishchuk_s.university.service;

import com.polishchuk_s.university.model.Schedule;
import com.polishchuk_s.university.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sSchedule {

    @Autowired
    ScheduleRepository scheduleRepository;

    public void saveSchedule(List<Schedule> schedules) {
        scheduleRepository.saveAll(schedules);
    }

    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }
}
