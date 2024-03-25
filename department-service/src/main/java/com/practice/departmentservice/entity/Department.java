package com.practice.departmentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "dep_sequence")
    @SequenceGenerator(name = "dep_sequence",
            sequenceName = "dep_sequence",
            allocationSize = 1
    )
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;

}
