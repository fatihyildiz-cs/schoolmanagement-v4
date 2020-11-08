package com.management.denkit.schoolmanagementv4.entity;

import com.management.denkit.schoolmanagementv4.enums.AdministrationStatus;
import com.management.denkit.schoolmanagementv4.enums.AdministrationStatusConverter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;

    @Convert(converter = AdministrationStatusConverter.class)
    private AdministrationStatus status;

    @ManyToOne
    @JoinColumn(name="subjectRef")
    private Subject subject;
}
