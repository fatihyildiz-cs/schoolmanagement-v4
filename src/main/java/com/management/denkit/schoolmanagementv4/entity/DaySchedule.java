package com.management.denkit.schoolmanagementv4.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@ToString
@NoArgsConstructor
public class DaySchedule {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;


    private Date date;

    @ManyToOne
    @JoinColumn(name="roomRef")
    private Room roomRef;

    @ManyToOne
    @JoinColumn(name="classroomRef")
    private Classroom classroomRef;

    @ManyToOne
    @JoinColumn(name="teacherRef1")
    private Teacher teacherRef1;

    @ManyToOne
    @JoinColumn(name="teacherRef2")
    private Teacher teacherRef2;

    @ManyToOne
    @JoinColumn(name="teacherRef3")
    private Teacher teacherRef3;

    @ManyToOne
    @JoinColumn(name="teacherRef4")
    private Teacher teacherRef4;

    @ManyToOne
    @JoinColumn(name="teacherRef5")
    private Teacher teacherRef5;

    @ManyToOne
    @JoinColumn(name="teacherRef6")
    private Teacher teacherRef6;
}
