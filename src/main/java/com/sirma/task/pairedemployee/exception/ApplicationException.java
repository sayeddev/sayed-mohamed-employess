package com.sirma.task.pairedemployee.exception;

import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException {
    private static final long serialVersionUID = 1439465498351813593L;
    private KeyError key;
    private String message;
    private HttpStatus status;

    public ApplicationException(KeyError key) {
        super(key.getKey());
        this.key = key;
        this.message = key.getKey();
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public ApplicationException(KeyError key, HttpStatus status) {
        super(key.getKey());
        this.key = key;
        this.message = key.getKey();
        this.status = status;
    }

    public ApplicationException(KeyError key, String message) {
        super("Error Code " + key.getKey() + " : Message {" + message + "}");
        this.key = key;
        this.message = message;
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public ApplicationException(KeyError key, String message, HttpStatus status) {
        super("Error Code " + key.getKey() + " : Message {" + message + "}");
        this.key = key;
        this.message = message;
        this.status = status;
    }

    public ApplicationException(KeyError key, String message, Throwable cause) {
        super("Error Code " + key.getKey() + " : Message {" + message + "}", cause);
        this.key = key;
        this.message = message;
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public ApplicationException(KeyError key, String message, Throwable cause, HttpStatus status) {
        super("Error Code " + key.getKey() + " : Message {" + message + "}", cause);
        this.key = key;
        this.message = message;
        this.status = status;
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