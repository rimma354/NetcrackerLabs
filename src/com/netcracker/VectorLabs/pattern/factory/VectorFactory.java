package com.netcracker.VectorLabs.pattern.factory;

import com.netcracker.VectorLabs.vector.*;

public interface VectorFactory {
    public Vector createVector();

    public Vector createVectorWithSize(int newSize);
}