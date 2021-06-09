package com.personal.csvreader.models;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    
    // private Object _id;
    @Id
    private int id;
    private String name;
    private String dob;
    private String manager;
    private String salary;
    private String department;

    // public Employee(int id, String name, String dob, String manager, String salary, String department) {
    //     this.id = id;
    //     this.name = name;
    //     this.dob = dob;
    //     this.manager = manager;
    //     this.salary = salary;
    //     this.department = department;
    // }

    
    
}
