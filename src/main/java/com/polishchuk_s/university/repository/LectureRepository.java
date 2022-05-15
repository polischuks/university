package com.polishchuk_s.university.repository;

import com.polishchuk_s.university.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LectureRepository extends JpaRepository<Lecture, String> {
}