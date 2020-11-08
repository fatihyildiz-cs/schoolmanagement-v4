package com.management.denkit.schoolmanagementv4.Service;


import com.management.denkit.schoolmanagementv4.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> findAllStudents();

    Student findStudentById(Integer id);

    Student updateStudent(Integer id, Student student);

    Student registerStudentToClass(Integer studentId, Integer classroomID);

    void deleteStudent(Student student);

    List<Student> findStudentByClassroomRefId(Integer classroomId);

    ResponseEntity<Object> createStudent(Student student);
}
