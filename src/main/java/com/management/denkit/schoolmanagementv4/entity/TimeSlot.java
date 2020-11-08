package com.management.denkit.schoolmanagementv4.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
@NoArgsConstructor
public class TimeSlot {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String dayName;

    @ManyToOne
    @JoinColumn(name="weeklyScheduleRef")
    private WeeklySchedule weeklyScheduleRef;

    @ManyToOne
    @JoinColumn(name="teacherRef")
    private Teacher teacherRef;

//    @ManyToOne
//    @JoinColumn(name="subjectRef")
//    private Subject subject;
}
