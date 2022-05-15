package com.polishchuk_s.university.controller;

import com.polishchuk_s.university.helper.hGroup;
import com.polishchuk_s.university.model.Group;
import com.polishchuk_s.university.service.sGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {

    @Autowired
    sGroup gService;

    @RequestMapping(value = "/group", method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<List<Group>> getGroup() {
        List<Group> listOfGroup = hGroup.initTableGroup();
        gService.save(listOfGroup);
        return new ResponseEntity<>(gService.getAllGroup(), HttpStatus.OK);
    }
}
