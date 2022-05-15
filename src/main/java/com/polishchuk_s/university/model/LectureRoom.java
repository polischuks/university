package com.polishchuk_s.university.model;

import javax.persistence.*;

@Entity
@Table(name = "lecture_room")
public class LectureRoom {


    public LectureRoom() {};

    public LectureRoom(Integer numberLectureRoom) {
        this.numberLectureRoom = numberLectureRoom;
    }

    @ManyToOne
    @JoinColumn(name = "id_couple")
    private Couple couple;

    public Couple getCouple() {
        return couple;
    }

    public void setCouple(Couple couple) {
        this.couple = couple;
    }

    public Integer getIdLectureRoom() {
        return idLectureRoom;
    }

    public void setIdLectureRoom(Integer idLectureRoom) {
        this.idLectureRoom = idLectureRoom;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lecture_room", nullable = false)
    private Integer idLectureRoom;

    @Column(name = "number_lecture_room")
    private Integer numberLectureRoom;

    public Integer getNumberLectureRoom() {
        return numberLectureRoom;
    }

    public void setNumberLectureRoom(Integer numberLectureRoom) {
        this.numberLectureRoom = numberLectureRoom;
    }

    public Integer getId() {
        return idLectureRoom;
    }

    public void setId(Integer id) {
        this.idLectureRoom = id;
    }

    @Override
    public String toString() {
        return " Номер аудитории " + numberLectureRoom;
    }
}