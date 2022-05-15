package com.polishchuk_s.university.helper;

import com.polishchuk_s.university.model.Group;

import java.util.ArrayList;
import java.util.List;

public class hGroup {

    public static List<Group> initTableGroup() {

        List<Group> listOfGroup = new ArrayList<>();
        double numberOfStudent = 20.0;

        int amountOfGroup = (int) Math.ceil(300 / numberOfStudent);
        for (int i = 1; i <= amountOfGroup; i++) {
            String name = "Group" + i;
            listOfGroup.add(new Group(i, name));
        }
        return listOfGroup;
    }
}
