package com.javi.uned.pfgcommons.exceptions;

public class ExportException extends Exception {

    public ExportException() {
        super();
    }

    public ExportException(String message) {
        super(message);
    }

    public ExportException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExportException(Throwable cause) {
        super(cause);
    }
}
