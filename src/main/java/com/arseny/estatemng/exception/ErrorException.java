package com.arseny.estatemng.exception;


public class ErrorException {
    private static final long serialVersionUID = 1L;
    private int code;
    private String status;
    private String message;

    public ErrorException(String msg, int code, String status){
        this.message = msg;
        this.code = code;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
