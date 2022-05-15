package com.polishchuk_s.university.service;

import com.polishchuk_s.university.helper.hExcelStudent;
import com.polishchuk_s.university.model.Student;
import com.polishchuk_s.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class sStudent {

    @Autowired
    StudentRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Student> student = hExcelStudent.excelToStudents(file.getInputStream());
            repository.saveAll(student);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public void saveGroupFromStudent(List<Student> student) {
        repository.saveAll(student);
    }

    public List<Student> getAllStudent() {
        return repository.findAll();
    }


}
