package com.bl.demo.exception;

public enum  ExceptionClass {
    NullException("Null Parameter Is Passed"),
    EmptyException( "Empty Parameter Is Passed"),
    ClassException("No Such Class Error"),
    MethodException("No Such Method Error"),
    FieldException("No Such Field Error");

    private final String exception;

    ExceptionClass(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }
}
