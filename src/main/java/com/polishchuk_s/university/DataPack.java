package com.polishchuk_s.university;

import com.polishchuk_s.university.model.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Getter
@Setter
@ToString
public class DataPack {

    List<DayOfWeek> dayOfWeeks;
    List<Couple> couples;
    List<Lecture> lectures;
    List<LectureRoom> lectureRooms;
    List<Teacher> teachers;
    List<Group> groups;
    List<Student> students;

    public DataPack(List<DayOfWeek> dayOfWeeks, List<Couple> couples,
                    List<Lecture> lectures, List<LectureRoom> lectureRooms,
                    List<Teacher> teachers, List<Group> groups, List<Student> students) {
        this.dayOfWeeks = dayOfWeeks;
        this.couples = couples;
        this.lectures = lectures;
        this.lectureRooms = lectureRooms;
        this.teachers = teachers;
        this.groups = groups;
        this.students = students;
    }
}
