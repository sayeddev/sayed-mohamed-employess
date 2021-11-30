package com.sirma.task.pairedemployee.entity;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.sirma.task.pairedemployee.utils.LocalDateConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class EmployeeProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @CsvBindByName(column = "EmpID")
    private Long employeeId;
    @CsvBindByName(column = "ProjectID")
    private Long projectId;
    @CsvCustomBindByName(column = "DateFrom", converter = LocalDateConverter.class)
    private LocalDate dateFrom;
    @CsvCustomBindByName(column = "DateTo", converter = LocalDateConverter.class)
    private LocalDate dateTo;
}
