package com.polishchuk_s.university.repository;

import com.polishchuk_s.university.model.LectureRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LectureRoomRepository extends JpaRepository<LectureRoom, Integer> {
}