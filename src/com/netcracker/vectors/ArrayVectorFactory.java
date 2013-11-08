package com.netcracker.vectors;


public class ArrayVectorFactory implements VectorFactory {
    public Vector createVector() {
        Vector v = new ArrayVector();
        return v;
    }

    public Vector createVectorWithSize(int newSize) {
        Vector v = new ArrayVector(newSize);
        return v;
    }
}