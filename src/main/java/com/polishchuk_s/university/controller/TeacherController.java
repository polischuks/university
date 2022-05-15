package com.polishchuk_s.university.controller;

import java.util.List;

import com.polishchuk_s.university.helper.hAddTeacherLectures;
import com.polishchuk_s.university.helper.hExcelLecture;
import com.polishchuk_s.university.helper.hExcelTeacher;
import com.polishchuk_s.university.model.Teacher;
import com.polishchuk_s.university.message.ResponseMessage;
import com.polishchuk_s.university.service.sLectures;
import com.polishchuk_s.university.service.sTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TeacherController {

    @Autowired
    sTeacher sTeacher;
    @Autowired
    sLectures sLectures;

    @RequestMapping(value="/teacher", method=RequestMethod.POST)
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (hExcelTeacher.hasExcelFormat(file)) {
            try {
                sTeacher.save(file);
                message = "Uploaded the helper successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the helper: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload an excel helper!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));

    }

    @RequestMapping(value = "/teacher", method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        try {
            List<Teacher> teachers = sTeacher.getAllTeacher();
            if (teachers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(teachers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/addlecture", method = RequestMethod.POST, produces ="application/json")
    public ResponseEntity<List<Teacher>> addTeacherLecture(@RequestParam("file") MultipartFile file) {

        if (hExcelLecture.hasExcelFormat(file)) {
            try {
                sLectures.saveImportExcel(file);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        List<Teacher> listOfTeachers = hAddTeacherLectures
                .addTeacherLectures(sTeacher.getAllTeacher(), sLectures.getAllLectures());
        sTeacher.saveAll(listOfTeachers);
        return new ResponseEntity<>(sTeacher.getAllTeacher(), HttpStatus.OK);
    }
}