package com.polishchuk_s.university.helper;

import com.polishchuk_s.university.DataPack;
import com.polishchuk_s.university.model.Schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class hGenerateSchedule {


    public static List<Schedule> generateSchedule(DataPack dataPack) {
        List<Schedule> schedules = new ArrayList<>();
        int i = 0;
        do {
            Schedule schedule = new Schedule();
            schedule.setDayOfWeek(dataPack.getDayOfWeeks().get(new Random().nextInt(5)).toString());
            schedule.setLecture(dataPack.getLectures().get(new Random().nextInt(14)).toString());
            schedule.setCouple(dataPack.getCouples().get(new Random().nextInt(7)).toString());
            schedule.setGroup(dataPack.getGroups().get(new Random().nextInt(15)).toString());
            schedule.setLecture_room(dataPack.getLectureRooms().get(new Random().nextInt(10)).toString());
            i++;
            if (i <= 100) schedules.add(schedule);
            else break;
        } while (true);
        return schedules;
    }
}
