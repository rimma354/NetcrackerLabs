package com.netcracker.VectorLabs.pattern.factory;

import com.netcracker.VectorLabs.vector.*;
import com.netcracker.VectorLabs.vector.impl.*;

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
