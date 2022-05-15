package com.polishchuk_s.university.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "lecture")
public class Lecture {

    @Id
    @Column(name = "id_lecture")
    int idLecture;

    @Column(name = "name_lecture")
    String nameLecture;

    public Lecture() {}

    public Lecture(int idLecture, String name) {
        this.idLecture = idLecture;
        this.nameLecture = name;
    }

    public int getIdLecture() {
        return idLecture;
    }

    public void setIdLecture(int idLecture) {
        this.idLecture = idLecture;
    }

    public String getNameLecture() {
        return nameLecture;
    }

    public void setNameLecture(String nameLecture) {
        this.nameLecture = nameLecture;
    }

    @Override
    public String toString() {
        return nameLecture;
    }
}