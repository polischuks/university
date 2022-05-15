package com.polishchuk_s.university.model;

import javax.persistence.*;

@Entity
@Table(name = "day_of_week")
public class DayOfWeek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_day", nullable = false)
    private Integer idDay;

    @Column(name = "day_week", nullable = false)
    private String dayOfWeek;

    public DayOfWeek() { }

    public DayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getIdDay() {
        return idDay;
    }

    public void setIdDay(Integer id) {
        this.idDay = id;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return dayOfWeek;
    }
}