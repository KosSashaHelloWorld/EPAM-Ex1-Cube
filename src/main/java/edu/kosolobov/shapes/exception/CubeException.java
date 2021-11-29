package edu.kosolobov.shapes.exception;
//TODO: By the developing CubeException became useless
public class CubeException extends Exception {
    public CubeException() {
    }

    public CubeException(String message) {
        super(message);
    }

    public CubeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CubeException(Throwable cause) {
        super(cause);
    }
}
