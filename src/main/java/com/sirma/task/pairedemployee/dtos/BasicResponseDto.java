package com.sirma.task.pairedemployee.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasicResponseDto {
    private HttpStatus httpStatus;
    private String errorCode;
    private String errorMessage;
}