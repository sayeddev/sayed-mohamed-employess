package com.sirma.task.pairedemployee;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sirma.task.pairedemployee.service.EmployeeProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AppStartupRunner implements ApplicationRunner {

    private final EmployeeProjectService employeeProjectService;

    @Override
    public void run(ApplicationArguments args) throws JsonProcessingException {
        log.info("Starting loading csv file data to db");
        employeeProjectService.saveEmployeeData();
        employeeProjectService.printPairedEmployees();
    }
}