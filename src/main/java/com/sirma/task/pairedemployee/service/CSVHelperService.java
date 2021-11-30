package com.sirma.task.pairedemployee.service;

import com.sirma.task.pairedemployee.entity.EmployeeProject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CSVHelperService {

    List<EmployeeProject> loadEmployeeProjects(String fileName);

    List<EmployeeProject> loadEmployeeProjects(MultipartFile file);
}
