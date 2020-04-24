package com.bl.demo.exception;

public enum  ExceptionClass {
    NullException("Null Parameter Is Passed"),
    EmptyException( "Empty Parameter Is Passed");

    private final String exception;

    ExceptionClass(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }
}
