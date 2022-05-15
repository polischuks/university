package com.polishchuk_s.university.service;

import com.polishchuk_s.university.model.Group;
import com.polishchuk_s.university.repository.GroupRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@SpringBootTest
class sGroupTest {

    List<Group> groups = new ArrayList<Group>();

    @Test
    void saveGroupFromRepository() {
        sGroup sGroup = mock(sGroup.class);
        groups.add(new Group(1, "1"));
        when(sGroup.save(groups)).thenReturn(groups);

    }

    @Test
    void getAllGroup() {
        GroupRepository gropRep = mock(GroupRepository.class);
        sGroup sGroup = mock(sGroup.class);

        groups.add(new Group(1, "1"));
        when(gropRep.findAll()).thenReturn(groups);
        when(sGroup.getAllGroup()).thenReturn(groups);

        boolean found = sGroup.getAllGroup().isEmpty();
        assertFalse(found);

    }
}