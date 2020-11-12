package com.management.denkit.schoolmanagementv4.controller;

import com.management.denkit.schoolmanagementv4.Service.DayScheduleService;
import com.management.denkit.schoolmanagementv4.entity.DaySchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v3/schedule")
public class DayScheduleController {

    @Autowired
    private DayScheduleService dayScheduleService;

    @GetMapping("/")
    public ResponseEntity<List<DaySchedule>> getAllDaySchedules(){

        return new ResponseEntity(dayScheduleService.findAllDaySchedules(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<DaySchedule> createDaySchedule(@RequestBody DaySchedule daySchedule){

        return new ResponseEntity(dayScheduleService.createDaySchedule(daySchedule), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteDaySchedule(@PathVariable Integer id){

        dayScheduleService.deleteDaySchedule(dayScheduleService.findDayScheduleById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DaySchedule> updateDaySchedule(@PathVariable Integer id, @RequestBody DaySchedule daySchedule){

        return new ResponseEntity(dayScheduleService.updateDaySchedule(id, daySchedule), HttpStatus.OK);
    }
}
