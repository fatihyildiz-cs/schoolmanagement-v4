package com.management.denkit.schoolmanagementv4.controller;

import com.management.denkit.schoolmanagementv4.Service.ClassroomService;
import com.management.denkit.schoolmanagementv4.Service.StudentService;
import com.management.denkit.schoolmanagementv4.Service.TeacherService;
import com.management.denkit.schoolmanagementv4.Service.WeeklyScheduleService;
import com.management.denkit.schoolmanagementv4.entity.Classroom;
import com.management.denkit.schoolmanagementv4.enums.DayName;
import com.management.denkit.schoolmanagementv4.model.WeeklyScheduleWithTimeSlotsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v3/classes"
//        , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE
)
public class ClassroomController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ClassroomService classroomService;
    @Autowired
    private WeeklyScheduleService weeklyScheduleService;

    @GetMapping("/")
    public ResponseEntity<List<Classroom>> getAllClasses(){

        return new ResponseEntity(classroomService.findAllClassrooms(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classroom> getClassById(@PathVariable Integer id){

        return new ResponseEntity(classroomService.findClassroomById(id), HttpStatus.OK);
    }

    @GetMapping("/{classId}/schedule/{dayName}")
    public ResponseEntity<WeeklyScheduleWithTimeSlotsModel> getWeeklyScheduleWithTimeSlotsByClassIdByDayName(@PathVariable Integer classId, @PathVariable(required = false) DayName dayName){

        return new ResponseEntity(weeklyScheduleService.findWeeklyScheduleWithTimeSlotsByClassId(classId, dayName.getDayName()), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Classroom> createClass(@RequestBody Classroom classroom){

        return new ResponseEntity(classroomService.createClassroom(classroom), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable Integer id){

        classroomService.deleteClassroom(classroomService.findClassroomById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classroom> updateClass(@PathVariable Integer id, @RequestBody Classroom classroom){

        return new ResponseEntity(classroomService.updateClassroom(id, classroom), HttpStatus.OK);
    }
}
