package com.personal.csvreader.services;

import java.util.List;

import com.personal.csvreader.models.Employee;

import org.springframework.web.multipart.MultipartFile;

public interface CSVService {
    public void save(MultipartFile file);
    public List<Employee> getAllEmployee();
}
