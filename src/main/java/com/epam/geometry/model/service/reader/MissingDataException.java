package com.epam.geometry.model.service.reader;

import java.io.IOException;

public class MissingDataException extends Exception {

    public MissingDataException() {
    }

    public MissingDataException(String message) {
        super(message);
    }

    public MissingDataException(String message, Exception cause) {
        super(message, cause);
    }

    public MissingDataException(Exception cause) {
        super(cause);
    }
}
