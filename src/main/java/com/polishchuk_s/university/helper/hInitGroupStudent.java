package com.polishchuk_s.university.helper;

import com.polishchuk_s.university.model.Group;
import com.polishchuk_s.university.model.Student;

import java.util.List;

public class hInitGroupStudent {

    public static List<Student> initGroupStudent(List<Student> students, List<Group> groups) {

        int numberStudent = 20;
        int item = 0;
        for (Group group : groups) {
            if (group.getId() == 1) item = 0;
            else item += numberStudent;
            int i = 1;
            for (int j = item; item < students.size(); j++) {
                if (i <= numberStudent) {
                    students.get(j).setGroup(group);
                    i++;
                }
                else break;
            }
        }
        return students;
    }
}
