package com.polishchuk_s.university.repository;

import com.polishchuk_s.university.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {

}