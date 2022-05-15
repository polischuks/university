package com.polishchuk_s.university.repository;

import com.polishchuk_s.university.model.Group;
import com.polishchuk_s.university.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByGroup(Group group);
}
