package com.management.denkit.schoolmanagementv4.controller;

import com.management.denkit.schoolmanagementv4.Service.TeacherService;
import com.management.denkit.schoolmanagementv4.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v3/teachers"
//        , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE
)
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/")
    public ResponseEntity<List<Teacher>> getAllTeachers(){

        return new ResponseEntity(teacherService.findAllTeachers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Integer id){


        return new ResponseEntity(teacherService.findTeacherById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher){

        return new ResponseEntity(teacherService.createTeacher(teacher), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Integer id){

        teacherService.deleteTeacher(teacherService.findTeacherById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Integer id, @RequestBody Teacher teacher){

        return new ResponseEntity(teacherService.updateTeacher(id, teacher), HttpStatus.OK);
    }
}
