package com.netcracker.vectors;

import java.util.*;
import java.io.*;

public interface Vector extends Serializable, Iterable<Double> {
    public void setElement(int i, double newValue);

    public double getElement(int i);

    public void print();

    public int getSize();

    public void populateWithArray(double[] array) throws IncompatibleVectorSizesException;

    public void populateWithObject(Vector obj) throws IncompatibleVectorSizesException;

    public void multiply(int x);

    public void add(Vector obj) throws IncompatibleVectorSizesException;

    public boolean compare(Vector obj) throws IncompatibleVectorSizesException;

    public String toString();

    public boolean equals(Object obj);

    public int hashCode();

    public Iterator iterator();

    public Vector clone() throws CloneNotSupportedException;
}