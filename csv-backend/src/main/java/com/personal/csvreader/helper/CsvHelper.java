package com.personal.csvreader.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import com.personal.csvreader.models.Employee;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

public class CsvHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "Id", "Name", "Age", "Manager","Salary","Department"};

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
          return false;
        }
    
        return true;
    }

    public static List<Employee> csvToEmployee(InputStream is){
        try{
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()); 

            List<Employee> employee = new ArrayList<Employee>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                Employee emp = new Employee(Integer.parseInt(csvRecord.get("Id")),
                                    csvRecord.get("Name"),
                                    csvRecord.get("Dob"),
                                    csvRecord.get("ReportingManager"),
                                    csvRecord.get("Salary"),
                                    csvRecord.get("Department"));
                employee.add(emp);
            }
            return employee;
        }
        catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }   
}
