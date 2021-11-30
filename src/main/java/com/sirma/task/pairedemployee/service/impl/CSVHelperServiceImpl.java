package com.sirma.task.pairedemployee.service.impl;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.sirma.task.pairedemployee.entity.EmployeeProject;
import com.sirma.task.pairedemployee.exception.BadRequestException;
import com.sirma.task.pairedemployee.service.CSVHelperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CSVHelperServiceImpl implements CSVHelperService {


    private final ResourceLoader resourceLoader;

    @Override
    public List<EmployeeProject> loadEmployeeProjects(String fileName) {
        try {
            Resource resource = resourceLoader.getResource("classpath:" + fileName);
            InputStream inputStream = resource.getInputStream();
            Reader reader = new InputStreamReader(inputStream);
            return parseCSV(reader);
        } catch (Exception ex) {
            log.error("Failure in parsing file ", ex);
            throw new BadRequestException("The file format is invalid");
        }
    }

    private List<EmployeeProject> parseCSV(Reader reader) {
        CsvToBean<EmployeeProject> csvToBean = new CsvToBeanBuilder(reader)
                .withType(EmployeeProject.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        return csvToBean.parse();
    }

    @Override
    public List<EmployeeProject> loadEmployeeProjects(MultipartFile file) {
        try {
            Reader reader = new InputStreamReader(file.getInputStream());
            return parseCSV(reader);
        } catch (Exception ex) {
            log.error("Failure in parsing file ", ex);
            throw new BadRequestException("The file format is invalid");
        }
    }
}