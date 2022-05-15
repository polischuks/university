package com.polishchuk_s.university.controller;

import com.polishchuk_s.university.DataPack;
import com.polishchuk_s.university.helper.hGenerateSchedule;
import com.polishchuk_s.university.model.Schedule;
import com.polishchuk_s.university.model.Student;
import com.polishchuk_s.university.model.Teacher;
import com.polishchuk_s.university.repository.*;
import com.polishchuk_s.university.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class MainController {

    @Autowired
    private sStudent studentService;
    @Autowired
    private sTeacher teacherService;
    @Autowired
    private sLectures lecturesService;
    @Autowired
    private sLectureRoom lectureRoomService;
    @Autowired
    private sDayOfWeek dayOfWeekService;
    @Autowired
    private sCouple coupleService;
    @Autowired
    private sGroup groupService;
    @Autowired
    private sSchedule scheduleService;


    public DataPack createDataPack() {
        return new DataPack(
                dayOfWeekService.getAllDay(),
                coupleService.getCouple(),
                lecturesService.getAllLectures(),
                lectureRoomService.getAllLectureRoom(),
                teacherService.getAllTeacher(),
                groupService.getAllGroup(),
                studentService.getAllStudent()
        );
    }

    @ResponseBody
    @RequestMapping(value = "/")
    public void home() {
      //  String html = "";
      //  html += "<ul>";
     //   html += " <li><a href='/createData'>Create data table</a></li>";
      //  html += " <li><a href='/showAllEmployee'>Show All Employee</a></li>";
     //   html += " <li><a href='/showFullNameLikeTom'>Show All 'Tom'</a></li>";
      //  html += " <li><a href='/deleteAllEmployee'>Delete All Employee</a></li>";
      //  html += "</ul>";
      //  return html;
    }

    @RequestMapping(value = "/schedule",method = RequestMethod.GET, produces="application/json")
    public ModelAndView getSchedule() {
        List<Schedule> schedules = hGenerateSchedule.generateSchedule(createDataPack());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("schedule");
        modelAndView.addObject("scheduled", schedules.stream()
                .filter(schedule -> Objects.equals(schedule.getDayOfWeek(), "Понедельник"))
                .collect(Collectors.toList()));
        return modelAndView;

    }
}
