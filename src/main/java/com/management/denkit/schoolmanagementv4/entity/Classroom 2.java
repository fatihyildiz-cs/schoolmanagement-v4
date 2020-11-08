package com.management.denkit.schoolmanagementv4.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

//import io.swagger.annotations.ApiModelProperty;

@Entity
@Data
@ToString
@NoArgsConstructor
public class Classroom{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private Integer year;
//    @OneDigitUpperCaseChar
//    @ApiModelProperty(notes = "Branch code must be a 1 digit uppercase char.")
    private String branch;

    @ManyToOne
    @JoinColumn(name="weeklyScheduleRef")
    private WeeklySchedule weeklyScheduleRef;

//    @Transient
//    private List<Student> studentList = new ArrayList<>();
}
