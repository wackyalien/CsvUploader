package com.personal.csvreader.services;

import java.io.IOException;
import java.util.List;

import com.personal.csvreader.helper.CsvHelper;
import com.personal.csvreader.models.Employee;
import com.personal.csvreader.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CSVServiceImpl implements CSVService{

    @Autowired
    private EmployeeRepository repository;

    @Override
    public void save(MultipartFile file) {
        try {
            List<Employee> emp = CsvHelper.csvToEmployee(file.getInputStream());
            repository.saveAll(emp);
          } 
          catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }    
    }

    @Override
    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }


    
}
