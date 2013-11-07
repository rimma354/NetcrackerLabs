package com.netcracker.vectors;
import java.util.*;
import java.io.*;

public interface Vector extends Serializable,Iterable<Double> {
    public void setElement(int i, double newValue);// throws VectorIndexOutOfBoundsException
    public double getElement(int i);              //  throws VectorIndexOutOfBoundsException
    public void print();
    public int getSize();
    public void populateWithArray(double[] array)throws IncompatibleVectorSizesException;
    public void populateWithObject(Vector obj)throws IncompatibleVectorSizesException;
    public void multiply(int x);
    public void add(Vector obj) throws IncompatibleVectorSizesException;
    public boolean compare(Vector obj) throws IncompatibleVectorSizesException;

}