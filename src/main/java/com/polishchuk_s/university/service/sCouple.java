package com.polishchuk_s.university.service;

import com.polishchuk_s.university.model.Couple;
import com.polishchuk_s.university.repository.CoupleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sCouple {

    @Autowired
    CoupleRepository coupleRepository;

    public void save(List<Couple> couples) {
        coupleRepository.saveAll(couples);
    }

    public List<Couple> getCouple() {
        return coupleRepository.findAll();
    }
}
