package com.sirma.task.pairedemployee.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sirma.task.pairedemployee.dtos.EmployeeProjectDto;
import com.sirma.task.pairedemployee.dtos.PairedEmployeesDto;
import com.sirma.task.pairedemployee.entity.EmployeeProject;
import com.sirma.task.pairedemployee.repository.EmployeeProjectRepository;
import com.sirma.task.pairedemployee.service.CSVHelperService;
import com.sirma.task.pairedemployee.service.EmployeeProjectService;
import com.sirma.task.pairedemployee.utils.MapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class EmployeeProjectServiceImpl implements EmployeeProjectService {

    private final EmployeeProjectRepository repository;
    private final CSVHelperService csvHelperService;
    private final MapperUtils mapperUtils;
    @Value("${setup.file.name}")
    private String fileName;

    @Override
    public void saveEmployeeData() {
        List<EmployeeProject> employeeProjects = csvHelperService.loadEmployeeProjects(fileName);
        if (!CollectionUtils.isEmpty(employeeProjects)) {
            repository.saveAll(employeeProjects);
        }
    }

    @Override
    public void saveEmployeeData(MultipartFile file) throws JsonProcessingException {
        List<EmployeeProject> employeeProjects = csvHelperService.loadEmployeeProjects(file);
        if (!CollectionUtils.isEmpty(employeeProjects)) {
            repository.saveAll(employeeProjects);
        }
        printPairedEmployees();

    }

    @Override
    public List<EmployeeProjectDto> getEmployeeProjects() {
        return mapperUtils.mapList(repository.findAll(), EmployeeProjectDto.class);
    }

    @Override
    public List<PairedEmployeesDto> getPairedEmployees() {
        return repository.getPairedEmployees();
    }

    @Override
    public void printPairedEmployees() throws JsonProcessingException {
        List<PairedEmployeesDto> pairedEmployees = getPairedEmployees();
        ObjectMapper objectMapper = new ObjectMapper();
        log.info("Results for paired employees");
        log.info("----------------------------------------------------------------------");
        log.info(objectMapper.writeValueAsString(pairedEmployees));
    }

    @Override
    public void deleteEmployeesData() {
        repository.deleteAll();
    }

}
