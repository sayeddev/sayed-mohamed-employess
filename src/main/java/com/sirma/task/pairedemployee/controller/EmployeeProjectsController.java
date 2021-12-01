package com.sirma.task.pairedemployee.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sirma.task.pairedemployee.dtos.EmployeeProjectDto;
import com.sirma.task.pairedemployee.dtos.PairedEmployeesDto;
import com.sirma.task.pairedemployee.service.EmployeeProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee-projects")
@Api(tags = "Employee Projects Management")
public class EmployeeProjectsController {

    private final EmployeeProjectService employeeProjectService;

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "get All Employees data")
    public ResponseEntity<List<EmployeeProjectDto>> getEmployeeProjects() {
        return ok(employeeProjectService.getEmployeeProjects());
    }

    @GetMapping("/paired")
    @ResponseBody
    @ApiOperation(value = "get All Paired Employees data")
    public ResponseEntity<List<PairedEmployeesDto>> getPairedEmployees() throws JsonProcessingException {
        return ok(employeeProjectService.getPairedEmployees());
    }

    @PostMapping("/upload")
    @ResponseBody
    @ApiOperation(value = "Upload new Employees data")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) throws JsonProcessingException {
        employeeProjectService.saveEmployeeData(file);
        return ok("File Uploaded successfully");
    }

    @DeleteMapping
    @ResponseBody
    @ApiOperation(value = "clear All Employees data")
    public ResponseEntity cleanData() {
        employeeProjectService.deleteEmployeesData();
        return ok("Employees Data removed");
    }

}
