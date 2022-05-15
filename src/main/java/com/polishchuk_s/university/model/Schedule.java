package com.polishchuk_s.university.model;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "day_of_week", nullable = false)
    private String dayOfWeek;

    @Column(name = "lecture", nullable = false)
    private String lecture;

    @Column(name = "couple", nullable = false)
    private String couple;

    @Column(name = "group", nullable = false)
    private String group;

    @Column(name = "lecture_room", nullable = false)
    private String lecture_room;

    public String getLecture_room() {
        return lecture_room;
    }

    public void setLecture_room(String lecture_room) {
        this.lecture_room = lecture_room;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getLecture() {
        return lecture;
    }

    public void setLecture(String lecture) {
        this.lecture = lecture;
    }

    public String getCouple() {
        return couple;
    }

    public void setCouple(String couple) {
        this.couple = couple;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getId() {
        return id;
    }


    public Schedule(String dayOfWeek, String lecture,
                    String couple, String group, String lecture_room) {

        this.dayOfWeek = dayOfWeek;
        this.lecture = lecture;
        this.couple = couple;
        this.group = group;
        this.lecture_room = lecture_room;
    }

    public Schedule() {}
}