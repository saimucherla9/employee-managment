package org.sai.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sai.model.EmployeeDTO;
import org.sai.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
   /* @Autowired
    private EmployeeService service;   // field auto-wiring

    @Autowired // Constructor auto-wiring
    EmployeeController(EmployeeService employeeService){
        this.service=employeeService;
    }*/
    // using annotation RequiredArgsConstructor auto-wiring
    private final EmployeeService employeeService;
    // write two apis save and all-data

    @PostMapping
    public ResponseEntity<EmployeeDTO> processEmployeeData(@RequestBody EmployeeDTO employeeDTO){
        log.info("saving the employee data started....");
        EmployeeDTO createdData = employeeService.saveEmployeeInfo(employeeDTO);
        return new ResponseEntity<>(createdData, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAllData(){
        log.info("getAllData the employee info started....");
        List<EmployeeDTO> response = employeeService.getAllData();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
