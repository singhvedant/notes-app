package com.bridgelabz.notesapplication.user.entity;

public class Response {

    private String message;
    private Object data;
    private int statusCode;

    public Response(String message, Object data, int statusCode) {
        this.message = message;
        this.data = data;
        this.statusCode = statusCode;
    }

    public Response(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
