package com.hello_world.first_api_java;

public class ReturnMessage {

    public ReturnMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ReturnMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
