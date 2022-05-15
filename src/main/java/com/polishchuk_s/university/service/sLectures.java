package com.polishchuk_s.university.service;

import com.polishchuk_s.university.helper.hExcelLecture;
import com.polishchuk_s.university.model.Lecture;
import com.polishchuk_s.university.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class sLectures {
    @Autowired
    LectureRepository lectureRepository;

    public void save(List<Lecture> lectures) {
        lectureRepository.saveAll(lectures);
    }

    public List<Lecture> getAllLectures(){
        return lectureRepository.findAll();
    }

    public void saveImportExcel(MultipartFile file) {
        try {
            List<Lecture> lectures = hExcelLecture.excelToLecture(file.getInputStream());
            lectureRepository.saveAll(lectures);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
}
