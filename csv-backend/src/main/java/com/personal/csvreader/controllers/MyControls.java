package com.personal.csvreader.controllers;

import java.util.List;

import com.personal.csvreader.helper.CsvHelper;
import com.personal.csvreader.models.Employee;
import com.personal.csvreader.services.CSVService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*") 
@RestController
public class MyControls {

    @Autowired
    private CSVService fileService;

    @GetMapping("/")
    public String hello(){
        return "Hello CSV";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file){
        // System.out.println("Inside request1");
        String message="";
        if(true){
            try{
                // System.out.println("Inside request2");
                fileService.save(file);
                message= "Uploaded the file successfully: "+ file.getOriginalFilename();
            }
            catch (Exception e){
                // System.out.println("Inside request3");
                message=  "Could not upload the file: " + file.getOriginalFilename() + "!"+e;
            } 
        }
        return message;
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return fileService.getAllEmployee();
    }
    
}
