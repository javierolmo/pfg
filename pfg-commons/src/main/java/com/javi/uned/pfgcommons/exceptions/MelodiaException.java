package com.javi.uned.pfgcommons.exceptions;

public class MelodiaException extends Exception {

    public MelodiaException() {
    }

    public MelodiaException(String message) {
        super(message);
    }

    public MelodiaException(String message, Throwable cause) {
        super(message, cause);
    }

    public MelodiaException(Throwable cause) {
        super(cause);
    }

}
