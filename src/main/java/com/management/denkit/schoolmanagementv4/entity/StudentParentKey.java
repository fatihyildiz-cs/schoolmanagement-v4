package com.management.denkit.schoolmanagementv4.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class StudentParentKey implements Serializable {

    @ManyToOne
    @JoinColumn(name= "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name= "parent_id")
    private Parent parent;

    public StudentParentKey(Student student, Parent parent) {
        this.student = student;
        this.parent = parent;
    }
// https://www.baeldung.com/spring-jpa-embedded-method-parameters
}
