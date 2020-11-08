package com.management.denkit.schoolmanagementv4.Service.serviceImpl;

import com.management.denkit.schoolmanagementv4.Service.*;
import com.management.denkit.schoolmanagementv4.entity.Parent;
import com.management.denkit.schoolmanagementv4.entity.Student;
import com.management.denkit.schoolmanagementv4.entity.StudentParent;
import com.management.denkit.schoolmanagementv4.entity.StudentParentKey;
import com.management.denkit.schoolmanagementv4.repository.StudentParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class StudentParentServiceImpl implements StudentParentService {

    @Autowired
    private StudentParentRepository studentParentRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassroomService classroomService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ParentService parentService;
    @Autowired
    private StudentParentService studentParentService;

    @Override
    public void assignStudentToParent(Integer studentId, Integer parentId) {

        if(studentParentService.findByStudentParentKeyParent(parentId).size() == 3) {
            throw new RuntimeException("A parent can have maximum of 3 students.");
        }
        if(studentParentService.findByStudentParentKeyStudent(studentId).size() == 2){
            throw new RuntimeException("A student can have maximum of 2 parents.");
        }
        Student student = studentService.findStudentById(studentId);
        Parent parent = parentService.findParentById(parentId);

        StudentParent studentParent = new StudentParent(new StudentParentKey(student,parent));
        studentParentRepository.save(studentParent);
    }

    @Override
    public List<StudentParent> findAllStudentParents() {

        return studentParentRepository.findAll();
    }

    @Override
    public StudentParent findStudentParentById(StudentParentKey studentParentKey) {
        return studentParentRepository.findById(studentParentKey).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<StudentParent> findByStudentParentKeyStudent(Integer studentId) {

        Student student = studentService.findStudentById(studentId);

        return studentParentRepository.findByStudentParentKeyStudent(student);
    }

    @Override
    public List<StudentParent> findByStudentParentKeyParent(Integer parentId) {

        Parent parent = parentService.findParentById(parentId);

        return studentParentRepository.findByStudentParentKeyParent(parent);
    }

    @Override
    public StudentParent saveStudentParent(StudentParent studentParent) {

        return studentParentRepository.save(studentParent);
    }

    @Override
    public void deleteStudentParent(StudentParent studentParent) {

        studentParentRepository.delete(studentParent);
    }
}
