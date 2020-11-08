package com.management.denkit.schoolmanagementv4.Service;

import com.management.denkit.schoolmanagementv4.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    List<Teacher> findAllTeachers();

    Teacher findTeacherById(Integer id);

    Teacher updateTeacher(Integer id, Teacher teacher);

    void deleteTeacher(Teacher teacher);

    Teacher createTeacher(Teacher teacher);
}
