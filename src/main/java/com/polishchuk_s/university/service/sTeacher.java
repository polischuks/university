package com.polishchuk_s.university.service;


import java.io.IOException;
import java.util.List;

import com.polishchuk_s.university.helper.hExcelTeacher;
import com.polishchuk_s.university.model.Teacher;
import com.polishchuk_s.university.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

    @Service
    public class sTeacher {
        @Autowired
        TeacherRepository repository;

        public void save(MultipartFile file) {
            try {
                List<Teacher> teachers = hExcelTeacher.excelToTeachers(file.getInputStream());
                repository.saveAll(teachers);
            } catch (IOException e) {
                throw new RuntimeException("fail to store excel data: " + e.getMessage());
            }
        }

        public List<Teacher> getAllTeacher() {
            return repository.findAll();
        }

        public void saveAll(List<Teacher> teachers) {
         repository.saveAll(teachers);
        }
}
