package com.polishchuk_s.university.model;

import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@Entity
@Table(name = "\"group\"")
public class Group {
    @Id
    @Column(name = "id_group", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Group(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Group() {}

    @Override
    public String toString() {
        return "Группа " + id;
    }
}