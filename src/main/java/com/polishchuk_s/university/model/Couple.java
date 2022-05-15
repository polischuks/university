package com.polishchuk_s.university.model;

import javax.persistence.*;

@Entity
@Table(name = "couple")
public class Couple {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_couple", nullable = false)
    private Integer iDCouple;

    @Column(name = "start_couple")
    private String startCouple;

    @Column(name = "end_couple")
    private String endCouple;


    public Couple(String startCouple, String endCouple) {
        this.startCouple = startCouple;
        this.endCouple = endCouple;
    }

    public Couple() {

    }

    public String getStartCouple() {
        return startCouple;
    }

    public void setStartCouple(String startCouple) {
        this.startCouple = startCouple;
    }

    public String getEndCouple() {
        return endCouple;
    }

    public void setEndCouple(String endCouple) {
        this.endCouple = endCouple;
    }

    public Integer getIdTLecture() {
        return iDCouple;
    }

    public void setIdTLecture(Integer idCouole) {
        this.iDCouple = idCouole;
    }

    @Override
    public String toString() {
        return startCouple + " - " + endCouple ;
    }
}