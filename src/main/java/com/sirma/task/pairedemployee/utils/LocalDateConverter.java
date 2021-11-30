package com.sirma.task.pairedemployee.utils;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateConverter extends AbstractBeanField {
    @Override
    protected Object convert(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        s = s.trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (s.equalsIgnoreCase("NULL")) {
            return LocalDate.now();
        }
        return LocalDate.parse(s, formatter);
    }
}
