package com.polishchuk_s.university.service;

import com.polishchuk_s.university.model.Group;
import com.polishchuk_s.university.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sGroup {

    @Autowired
    GroupRepository groupRepository;

    public List<Group> save(List<Group> group) {
        groupRepository.saveAll(group);
        return group;
    }

    public List<Group> getAllGroup() {
        return groupRepository.findAll();
    }

}
