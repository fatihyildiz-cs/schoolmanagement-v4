package com.management.denkit.schoolmanagementv4.controller;

import com.management.denkit.schoolmanagementv4.Service.ParentService;
import com.management.denkit.schoolmanagementv4.entity.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v3/parents")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @GetMapping("/")
    public ResponseEntity<List<Parent>> getAllParents(){

        return new ResponseEntity(parentService.findAllParents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parent> getParentById(@PathVariable Integer id){


        return new ResponseEntity(parentService.findParentById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Parent> createParent(@RequestBody Parent parent){

        return new ResponseEntity(parentService.createParent(parent), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public void deleteParent(@PathVariable Integer id){

        parentService.deleteParent(parentService.findParentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parent> updateParent(@PathVariable Integer id, @RequestBody Parent parent){

        return new ResponseEntity(parentService.updateParent(id, parent), HttpStatus.OK);
    }
}
