package com.management.denkit.schoolmanagementv4.controller;

import com.management.denkit.schoolmanagementv4.Service.ClassroomService;
import com.management.denkit.schoolmanagementv4.Service.StudentService;
import com.management.denkit.schoolmanagementv4.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v3/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassroomService classroomService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getAllStudents() {

        return new ResponseEntity(studentService.findAllStudents(), HttpStatus.OK);
    }


    @GetMapping(value = "/studentlistofclass/{classroomId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getAllStudentsInClass(@PathVariable Integer classroomId) {

        return new ResponseEntity(studentService.findStudentByClassroomRefId(classroomId), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {

        return new ResponseEntity(studentService.findStudentById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {

        return studentService.createStudent(student);
    }

    @GetMapping(value = "/register/{studentId}/{classId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> registerStudentToClass(@PathVariable Integer studentId, @PathVariable Integer classId) {

        return new ResponseEntity(studentService.registerStudentToClass(studentId, classId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {

        studentService.deleteStudent(studentService.findStudentById(id));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student) {

        return new ResponseEntity(studentService.updateStudent(id, student), HttpStatus.OK);
    }
}

