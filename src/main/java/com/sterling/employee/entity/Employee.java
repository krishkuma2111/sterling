package com.sterling.employee.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table("employees")
public class Employee {

    @Id
    private Long id;

    @Column("employee_name")
    private String employeeName;

    private Double salary;
}
