package com.polishchuk_s.university.helper;

import com.polishchuk_s.university.model.Lecture;
import com.polishchuk_s.university.model.Teacher;

import java.util.List;

public class hAddTeacherLectures {

    public static List<Teacher> addTeacherLectures(List<Teacher> teachers, List<Lecture> lectures) {
        if (!teachers.isEmpty() && !lectures.isEmpty()) {
            for (int i = 0; i < lectures.size(); i++) {
                teachers.get(i).setLecture(lectures.get(i));
            }
        }
        return teachers;
    }

}
