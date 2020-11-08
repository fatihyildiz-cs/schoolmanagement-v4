package com.management.denkit.schoolmanagementv4.entity;

import com.management.denkit.schoolmanagementv4.annotation.OneDigitUpperCaseChar;
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

    @OneDigitUpperCaseChar
    private String branch;

    @OneToOne
    @JoinColumn(name="weeklyScheduleRef")
    private WeeklySchedule weeklyScheduleRef;

//    @Transient
//    private List<Student> studentList = new ArrayList<>();
}
