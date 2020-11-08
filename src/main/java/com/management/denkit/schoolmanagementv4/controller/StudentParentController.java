package com.management.denkit.schoolmanagementv4.controller;

import com.management.denkit.schoolmanagementv4.Service.ClassroomService;
import com.management.denkit.schoolmanagementv4.Service.StudentParentService;
import com.management.denkit.schoolmanagementv4.Service.StudentService;
import com.management.denkit.schoolmanagementv4.Service.TeacherService;
import com.management.denkit.schoolmanagementv4.entity.StudentParent;
import com.management.denkit.schoolmanagementv4.entity.StudentParentKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v3/family")
public class StudentParentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ClassroomService classroomService;
    @Autowired
    private StudentParentService studentParentService;
    @GetMapping("/")
    public ResponseEntity<List<StudentParent>> getAllStudentParents(){

        return new ResponseEntity(studentParentService.findAllStudentParents(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<StudentParent> findById(@RequestBody StudentParentKey studentParentKey){

        return new ResponseEntity(studentParentService.findStudentParentById(studentParentKey), HttpStatus.OK);
    }

    @GetMapping("/findbystudentid/{studentId}")
    public ResponseEntity<List<StudentParent>> findAllByStudentId(@PathVariable Integer studentId){

        return new ResponseEntity(studentParentService.findByStudentParentKeyStudent(studentId), HttpStatus.OK);
    }

    @GetMapping("/findbyparentid/{parentId}")
    public ResponseEntity<List<StudentParent>> findAllByParentId(@PathVariable Integer parentId){

        return new ResponseEntity(studentParentService.findByStudentParentKeyParent(parentId), HttpStatus.OK);
    }

    @GetMapping("/assign/{studentId}/{parentId}")
    public void AssignStudentToParent(@PathVariable Integer studentId, @PathVariable Integer parentId){

        studentParentService.assignStudentToParent(studentId, parentId);
    }
}
