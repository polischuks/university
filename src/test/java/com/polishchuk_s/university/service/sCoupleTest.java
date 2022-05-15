package com.polishchuk_s.university.service;

import com.polishchuk_s.university.model.Couple;
import com.polishchuk_s.university.repository.CoupleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class sCoupleTest {

    @Autowired
    CoupleRepository coupleRepository;

    @Test
    void getCouple() {

        List<Couple> couples = coupleRepository.findAll();
        boolean actual = couples.isEmpty();
        assertFalse(actual);
    }
}