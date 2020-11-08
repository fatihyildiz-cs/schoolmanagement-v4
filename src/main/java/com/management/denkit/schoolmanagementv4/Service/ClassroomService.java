package com.management.denkit.schoolmanagementv4.Service;

import com.management.denkit.schoolmanagementv4.entity.Classroom;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassroomService {

    List<Classroom> findAllClassrooms();

    Classroom findClassroomById(Integer id);

    Classroom createClassroom(Classroom classroom);

    void deleteClassroom(Classroom classroom);

    Classroom updateClassroom(Integer id, Classroom classroom);
}
