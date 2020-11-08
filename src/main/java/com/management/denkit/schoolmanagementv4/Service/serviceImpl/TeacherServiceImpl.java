package com.management.denkit.schoolmanagementv4.Service.serviceImpl;


import com.management.denkit.schoolmanagementv4.Service.ClassroomService;
import com.management.denkit.schoolmanagementv4.Service.StudentService;
import com.management.denkit.schoolmanagementv4.Service.TeacherService;
import com.management.denkit.schoolmanagementv4.entity.Teacher;
import com.management.denkit.schoolmanagementv4.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassroomService classroomService;
    @Autowired
    private TeacherService teacherService;

    @Override
    public List<Teacher> findAllTeachers() {

        return teacherRepository.findAll();
    }

    @Override
    public Teacher findTeacherById(Integer id) {

        return teacherRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Teacher updateTeacher(Integer id, Teacher teacher) {

        Teacher actualTeacher = teacherService.findTeacherById(id);

        actualTeacher.setFirstName(teacher.getFirstName());
        actualTeacher.setLastName(teacher.getLastName());
        actualTeacher.setSubject(teacher.getSubject());

        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {

        teacherRepository.delete(teacher);
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {

        return teacherRepository.save(teacher);
    }
}
