package com.polishchuk_s.university.repository;

import com.polishchuk_s.university.model.Couple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CoupleRepository extends JpaRepository<Couple, Integer> {}


