package com.polishchuk_s.university.repository;

import com.polishchuk_s.university.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}