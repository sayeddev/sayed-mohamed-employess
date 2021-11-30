package com.sirma.task.pairedemployee.exception;

import com.sirma.task.pairedemployee.dtos.BasicResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ExceptionHandler({ApplicationException.class})
    public ResponseEntity<BasicResponseDto> exceptionHandler(ApplicationException ex) {
        log.error("Error :: ", ex);
        KeyError errorKey = BasicErrorKeyError.GENERAL;
        if (ex.getKey() != null) {
            errorKey = ex.getKey();
        }
        return this.getResponseEntity(ex.getStatus(), ex.getMessage(), errorKey);
    }


    @ExceptionHandler({Exception.class})
    public ResponseEntity<BasicResponseDto> exceptionHandler(Exception ex) {
        log.error("Error :: ", ex);
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        KeyError errorKey = BasicErrorKeyError.GENERAL;
        return this.getResponseEntity(httpStatus, ex.getMessage(), errorKey);
    }

    private ResponseEntity<BasicResponseDto> getResponseEntity(HttpStatus httpStatus, String errorMessage, KeyError errorKey) {
        BasicResponseDto error = this.createErrorResponse(errorKey, errorMessage, httpStatus);
        return new ResponseEntity(error, error.getHttpStatus());
    }

    private BasicResponseDto createErrorResponse(KeyError errorKey, String errorMessage, HttpStatus httpStatus) {
        BasicResponseDto errorResponse = new BasicResponseDto();
        errorResponse.setErrorCode(errorKey.getKey());
        errorResponse.setErrorMessage(errorMessage);
        errorResponse.setHttpStatus(httpStatus);
        return errorResponse;
    }
}
