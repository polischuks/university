package com.polishchuk_s.university.controller;

import com.polishchuk_s.university.helper.hExcelStudent;
import com.polishchuk_s.university.helper.hInitGroupStudent;
import com.polishchuk_s.university.message.ResponseMessage;
import com.polishchuk_s.university.model.Group;
import com.polishchuk_s.university.model.Student;
import com.polishchuk_s.university.service.sGroup;
import com.polishchuk_s.university.service.sStudent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    sStudent fileService;
    @Autowired
    sGroup gService;

    @RequestMapping(value="/student", method=RequestMethod.POST)
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (hExcelStudent.hasExcelFormat(file)) {
            try {
                fileService.save(file);
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

    @RequestMapping(value = "/student/view", method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<List<Student>> getAllStudents() {
        try {
            List<Student> students = fileService.getAllStudent();
            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/student/group", method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<List<Student>> createGroupStudent() {

        List<Student> students = fileService.getAllStudent();
        List<Group> groups = gService.getAllGroup();
        fileService.saveGroupFromStudent(hInitGroupStudent.initGroupStudent(students, groups));
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}