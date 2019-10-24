package com.netcracker.tc.server.service.exception;

public class ServiceException extends Exception{

    private long errorCode;

    public ServiceException(long errorCode){
        this.errorCode = errorCode;
    }

    public ServiceException(String message){
        super(message);
    }

    public long getErrorCode() {
        return errorCode;
    }
}