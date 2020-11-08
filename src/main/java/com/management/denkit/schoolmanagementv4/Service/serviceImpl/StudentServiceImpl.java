package com.management.denkit.schoolmanagementv4.Service.serviceImpl;

import com.management.denkit.schoolmanagementv4.Service.ClassroomService;
import com.management.denkit.schoolmanagementv4.Service.StudentService;
import com.management.denkit.schoolmanagementv4.Service.TeacherService;
import com.management.denkit.schoolmanagementv4.entity.Classroom;
import com.management.denkit.schoolmanagementv4.entity.Student;
import com.management.denkit.schoolmanagementv4.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassroomService classroomService;
    @Autowired
    private TeacherService teacherService;


    @Override
    public List<Student> findAllStudents() {

        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(Integer id) {

        return studentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Student updateStudent(Integer id, Student student) {

        Student actualStudent = studentService.findStudentById(id);

        actualStudent.setFirstName(student.getFirstName());
        actualStudent.setLastName(student.getLastName());

        return studentRepository.save(actualStudent);
    }

    @Override
    public Student registerStudentToClass(Integer studentId, Integer classroomId) {

        Classroom actualClass = classroomService.findClassroomById(classroomId);
        Student actualStudent = studentService.findStudentById(studentId);
        actualStudent.setClassroomRef(actualClass);

        return studentRepository.save(actualStudent);
    }

    @Override
    public void deleteStudent(Student student) {

        studentRepository.delete(student);
    }

    @Override
    public List<Student> findStudentByClassroomRefId(Integer classroomId) {

        return studentRepository.findByClassroomRefIdOrderByFirstNameAscLastNameAsc(classroomId);
    }

    @Override
    public ResponseEntity<Object> createStudent(Student student) {

        Student savedStudent = studentRepository.save(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedStudent.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
