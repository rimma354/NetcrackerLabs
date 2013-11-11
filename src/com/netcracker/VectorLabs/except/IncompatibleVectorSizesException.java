package com.netcracker.VectorLabs.except;

public class IncompatibleVectorSizesException extends Exception {
    public IncompatibleVectorSizesException(String str) {
        super(str);
    }

    public IncompatibleVectorSizesException() {
        super();
    }

    public String toString() {
        return "IncompatibleVectorSizesException";
    }
}