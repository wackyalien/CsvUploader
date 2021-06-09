package com.personal.csvreader.repository;

import com.personal.csvreader.models.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,Integer>{
    
}
