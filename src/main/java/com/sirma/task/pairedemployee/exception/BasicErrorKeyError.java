package com.sirma.task.pairedemployee.exception;


public enum BasicErrorKeyError implements KeyError {
    GENERAL("GENERAL"),
    BAD_REQUEST("BAD_REQUEST");

    private String key;

    private BasicErrorKeyError(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}

