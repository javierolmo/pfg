package com.javi.uned.pfg.exceptions.runtime;

public class AnalyzerRuntimeException extends MelodiaRuntimeException {

    public AnalyzerRuntimeException() {
        super();
    }

    public AnalyzerRuntimeException(String message) {
        super(message);
    }

    public AnalyzerRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AnalyzerRuntimeException(Throwable cause) {
        super(cause);
    }
}
