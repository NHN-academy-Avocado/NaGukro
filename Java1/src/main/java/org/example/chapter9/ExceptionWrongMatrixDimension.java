package org.example.chapter9;

public class ExceptionWrongMatrixDimension extends Throwable {
    public ExceptionWrongMatrixDimension(String message) {
        super(message);
    }
}
