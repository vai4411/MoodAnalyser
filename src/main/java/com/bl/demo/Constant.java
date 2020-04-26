package com.bl.demo;

public enum  Constant {
    Happy("I Am In Happy Mood"),
    Sad("I Am In Sad Mood"),
    Any("I Am In Any Mood"),
    Null("Null Parameter Is Passed"),
    Empty( "Empty Parameter Is Passed"),
    ClassNotFound("No Such Class Error"),
    MethodNotFound("No Such Method Error"),
    FieldNotFound("No Such Field Error");

    private final String message;

    Constant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
