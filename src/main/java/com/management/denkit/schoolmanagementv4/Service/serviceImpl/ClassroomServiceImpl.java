package com.management.denkit.schoolmanagementv4.Service.serviceImpl;

import com.management.denkit.schoolmanagementv4.Service.ClassroomService;
import com.management.denkit.schoolmanagementv4.Service.StudentService;
import com.management.denkit.schoolmanagementv4.Service.TeacherService;
import com.management.denkit.schoolmanagementv4.entity.Classroom;
import com.management.denkit.schoolmanagementv4.repository.ClassroomRepository;
import com.management.denkit.schoolmanagementv4.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassroomService classroomService;
    @Autowired
    private TeacherService teacherService;

    @Override
    public List<Classroom> findAllClassrooms() {

        List<Classroom> allClasses = classroomRepository.findAllByOrderByGradeAscBranchAsc();

        return allClasses;
    }

    @Override
    public Classroom findClassroomById(Integer id) {

        Classroom classroom = classroomRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        return classroom;
    }

    @Override
    public Classroom createClassroom(Classroom classroom) {

        return classroomRepository.save(classroom);
    }

    @Override
    public void deleteClassroom(Classroom classroom) {

        classroomRepository.delete(classroom);
    }

    @Override
    public Classroom updateClassroom(Integer id, Classroom classroom) {

        Classroom actualClass  = classroomService.findClassroomById(id);

        actualClass.setBranch(classroom.getBranch());
        actualClass.setGrade(classroom.getGrade());

        return classroomRepository.save(actualClass);
    }
}
