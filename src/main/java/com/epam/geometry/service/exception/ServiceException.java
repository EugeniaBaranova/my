package com.epam.geometry.service.exception;

public class ServiceException extends RuntimeException {
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Exception cause) {
        super(message, cause);
    }

    public ServiceException(Exception cause) {
        super(cause);
    }
}
