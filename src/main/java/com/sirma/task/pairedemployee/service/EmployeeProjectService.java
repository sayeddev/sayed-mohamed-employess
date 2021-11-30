package com.sirma.task.pairedemployee.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sirma.task.pairedemployee.dtos.EmployeeProjectDto;
import com.sirma.task.pairedemployee.dtos.PairedEmployeesDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeProjectService {

    void saveEmployeeData();

    void saveEmployeeData(MultipartFile file) throws JsonProcessingException;

    List<EmployeeProjectDto> getEmployeeProjects();

    List<PairedEmployeesDto> getPairedEmployees() throws JsonProcessingException;

    void printPairedEmployees() throws JsonProcessingException;
}
