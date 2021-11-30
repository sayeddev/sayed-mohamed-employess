package com.sirma.task.pairedemployee.repository;

import com.sirma.task.pairedemployee.dtos.PairedEmployeesDto;
import com.sirma.task.pairedemployee.entity.EmployeeProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Long> {

    @Query(value = "SELECT distinct e1.employee_id AS firstEmployeeId,\n" +
            "                         e2.employee_id AS secondEmployeeId ,\n" +
            "                         e1.project_id AS projectId ,\n" +
            "                         Datediff(day, (\n" +
            "                         CASE\n" +
            "                                  WHEN e1.date_from > e2.date_from THEN e1.date_from\n" +
            "                                  ELSE e2.date_from\n" +
            "                         END), (\n" +
            "                         CASE\n" +
            "                                  WHEN e2.date_to < e1.date_to THEN e2.date_to\n" +
            "                                  ELSE e1.date_to\n" +
            "                         END) ) AS days\n" +
            "                FROM     employee_project e1\n" +
            "                JOIN     employee_project e2\n" +
            "                ON       e1.project_id = e2.project_id\n" +
            "                AND      e1.employee_id < e2.employee_id\n" +
            "\n" +
            "                GROUP BY e1.employee_id,\n" +
            "                         e2.employee_id\n" +
            "\t\thaving days > 0\n" +
            "                ORDER BY days DESC", nativeQuery = true)
    List<PairedEmployeesDto> getPairedEmployees();
}
