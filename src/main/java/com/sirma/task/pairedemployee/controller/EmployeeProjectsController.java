package com.sirma.task.pairedemployee.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sirma.task.pairedemployee.dtos.EmployeeProjectDto;
import com.sirma.task.pairedemployee.dtos.PairedEmployeesDto;
import com.sirma.task.pairedemployee.service.EmployeeProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee-projects")
public class EmployeeProjectsController {

    private final EmployeeProjectService employeeProjectService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<EmployeeProjectDto>> getEmployeeProjects() {
        return ok(employeeProjectService.getEmployeeProjects());
    }

    @GetMapping("/paired")
    @ResponseBody
    public ResponseEntity<List<PairedEmployeesDto>> getPairedEmployees() throws JsonProcessingException {
        return ok(employeeProjectService.getPairedEmployees());
    }

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) throws JsonProcessingException {
        employeeProjectService.saveEmployeeData(file);
        return ok("File Uploaded successfully");
    }
}
