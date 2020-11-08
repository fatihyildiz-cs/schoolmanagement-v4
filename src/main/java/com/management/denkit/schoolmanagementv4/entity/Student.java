package com.management.denkit.schoolmanagementv4.entity;

import com.management.denkit.schoolmanagementv4.annotation.StateIdentityNumber;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

//import io.swagger.annotations.ApiModel;

@Entity
@Data
@ToString
@NoArgsConstructor
//@ApiModel(description = "This is a description about the student entity.")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    @StateIdentityNumber
    private Long stateIdentityNum;

    @ManyToOne
    @JoinColumn(name="classroomRef")
    private Classroom classroomRef;
}
