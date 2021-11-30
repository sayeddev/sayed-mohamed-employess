package com.sirma.task.pairedemployee.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeProjectDto implements Serializable {
    private Long employeeId;
    private Long projectId;
    private LocalDate dateFrom;
    private LocalDate dateTo;
}
