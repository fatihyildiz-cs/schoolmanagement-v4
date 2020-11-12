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
public class Room {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String floor;
}
