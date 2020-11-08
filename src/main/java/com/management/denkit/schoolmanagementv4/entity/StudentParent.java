package com.management.denkit.schoolmanagementv4.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class StudentParent {

    @EmbeddedId
    private StudentParentKey studentParentKey;

//    @Column(name = "assignment_duration")
//    private Integer assignmentDuration = 3;

    public StudentParent(StudentParentKey studentParentKey) {
        this.studentParentKey = studentParentKey;
    }
}
