package com.polishchuk_s.university.service;

import com.polishchuk_s.university.model.DayOfWeek;
import com.polishchuk_s.university.repository.DayOfWeekRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class sDayOfWeekTest {

    @Autowired
    DayOfWeekRepository dayOfWeekRepository;

    @Test
    void getAllDay() {

        List<DayOfWeek> dayOfWeeks = dayOfWeekRepository.findAll();
        boolean found = dayOfWeeks.isEmpty();
        assertFalse(found);
    }
}