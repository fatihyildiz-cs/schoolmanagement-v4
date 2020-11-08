package com.management.denkit.schoolmanagementv4.controller;

import com.management.denkit.schoolmanagementv4.Service.WeeklyScheduleService;
import com.management.denkit.schoolmanagementv4.entity.TimeSlot;
import com.management.denkit.schoolmanagementv4.entity.WeeklySchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v3/schedule")
public class WeeklyScheduleController {

    @Autowired
    private WeeklyScheduleService weeklyScheduleService;

    @GetMapping("/")
    public ResponseEntity<List<WeeklySchedule>> getAllWeeklySchedules(){

        return new ResponseEntity(weeklyScheduleService.findAllWeeklySchedules(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<WeeklySchedule> getWeeklyScheduleById(@PathVariable Integer id){


        return new ResponseEntity(weeklyScheduleService.findWeeklyScheduleWithTimeSlotsByClassId(id,null), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<WeeklySchedule> createWeeklySchedule(@RequestBody WeeklySchedule weeklySchedule){

        return new ResponseEntity(weeklyScheduleService.createWeeklySchedule(weeklySchedule), HttpStatus.OK);
    }

    @GetMapping("/slot/{slotId}/assigntoteacher/{teacherId}")
    public ResponseEntity<TimeSlot> assignTimeSlotToTeacher(@PathVariable Integer slotId, @PathVariable Integer teacherId){

        return new ResponseEntity(weeklyScheduleService.assignTimeSlotToTeacher(slotId,teacherId), HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public void deleteWeeklySchedule(@PathVariable Integer id){

        weeklyScheduleService.deleteWeeklySchedule(weeklyScheduleService.findWeeklyScheduleById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WeeklySchedule> updateWeeklySchedule(@PathVariable Integer id, @RequestBody WeeklySchedule weeklySchedule){

        return new ResponseEntity(weeklyScheduleService.updateWeeklySchedule(id, weeklySchedule), HttpStatus.OK);
    }
}
