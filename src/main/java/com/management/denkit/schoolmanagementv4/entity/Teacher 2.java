package com.management.denkit.schoolmanagementv4.entity;

import com.management.denkit.schoolmanagementv4.enums.AdministrationStatus;
import com.management.denkit.schoolmanagementv4.enums.SubjectType;
import com.management.denkit.schoolmanagementv4.enums.SubjectTypeConverter;
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

    @Convert(converter = AdministrationStatus.class)
    private AdministrationStatus status;

    @Convert(converter = SubjectTypeConverter.class)
    private SubjectType subject;
}
