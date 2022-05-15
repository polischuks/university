package com.polishchuk_s.university.repository;

import com.polishchuk_s.university.model.DayOfWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DayOfWeekRepository extends JpaRepository<DayOfWeek, Integer> {
    @Override
    List<DayOfWeek> findAll();
}