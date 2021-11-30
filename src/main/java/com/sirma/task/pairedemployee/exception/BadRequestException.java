package com.sirma.task.pairedemployee.exception;


import org.springframework.http.HttpStatus;

public class BadRequestException extends ApplicationException {
    private static final long serialVersionUID = 1439465498351813593L;
    private KeyError key;
    private String message;
    private HttpStatus status;

    public BadRequestException() {
        super(BasicErrorKeyError.BAD_REQUEST);
        this.key = BasicErrorKeyError.BAD_REQUEST;
        this.message = this.key.getKey();
        this.status = HttpStatus.BAD_REQUEST;
    }

    public BadRequestException(KeyError key) {
        super(key);
        this.key = key;
        this.message = key.getKey();
        this.status = HttpStatus.BAD_REQUEST;
    }

    public BadRequestException(String message) {
        super(BasicErrorKeyError.BAD_REQUEST);
        this.key = BasicErrorKeyError.BAD_REQUEST;
        this.message = message;
        this.status = HttpStatus.BAD_REQUEST;
    }

    public KeyError getKey() {
        return this.key;
    }

    public void setKey(KeyError key) {
        this.key = key;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
