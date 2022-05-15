package com.polishchuk_s.university.service;

import com.polishchuk_s.university.model.LectureRoom;
import com.polishchuk_s.university.repository.LectureRepository;
import com.polishchuk_s.university.repository.LectureRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sLectureRoom {

    @Autowired
    LectureRoomRepository lectureRoomRepository;

    public List<LectureRoom> getAllLectureRoom() {
        return lectureRoomRepository.findAll();
    }
}
