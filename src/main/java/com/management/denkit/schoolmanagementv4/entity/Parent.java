package com.management.denkit.schoolmanagementv4.entity;

import com.management.denkit.schoolmanagementv4.annotation.StateIdentityNumber;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
@ToString
@NoArgsConstructor
public class Parent {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    @StateIdentityNumber
    private String stateId;

    @ManyToOne
    @JoinColumn
    private Student studentRef;

    @Email
    private String email;

    private String phoneNumber;

//    @ManyToOne
//    @JoinColumn(name = "studentRef1")
//    private Student student1;
//
//    @ManyToOne
//    @JoinColumn(name = "studentRef2")
//    private Student student2;
//
//    @ManyToOne
//    @JoinColumn(name = "studentRef3")
//    private Student student3;

}
