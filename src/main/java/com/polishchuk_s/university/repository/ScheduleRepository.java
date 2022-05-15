package com.polishchuk_s.university.repository;

import com.polishchuk_s.university.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}