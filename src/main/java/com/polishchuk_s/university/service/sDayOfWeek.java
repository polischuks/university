package com.polishchuk_s.university.service;

import com.polishchuk_s.university.model.DayOfWeek;
import com.polishchuk_s.university.repository.DayOfWeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sDayOfWeek {

    @Autowired
    DayOfWeekRepository dayOfWeekRepository;

    public List<DayOfWeek> getAllDay() {
        return dayOfWeekRepository.findAll();
    }
}
