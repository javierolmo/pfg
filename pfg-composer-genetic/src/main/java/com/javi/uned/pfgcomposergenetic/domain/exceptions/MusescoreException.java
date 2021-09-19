package com.javi.uned.pfgcomposergenetic.domain.exceptions;

public class MusescoreException extends Exception {

    public MusescoreException() {
    }

    public MusescoreException(String message) {
        super(message);
    }

    public MusescoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public MusescoreException(Throwable cause) {
        super(cause);
    }
}
