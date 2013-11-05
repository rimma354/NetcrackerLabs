package com.netcracker.vectors;
import java.util.*;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Rimma
 * Date: 24.10.13
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
 */
public interface Vector extends Serializable,Iterable<Double> {
    public void setElement(int i, double newValue);
    public double getElement(int i);
    public void print();
    public int getSize();
    public void populateWithArray(double[] array)throws IncompatibleVectorSizesException;
    public void populateWithObject(Vector obj)throws IncompatibleVectorSizesException;
    public void multiply(int x);
    public void add(Vector obj) throws IncompatibleVectorSizesException;
    public boolean compare(Vector obj) throws IncompatibleVectorSizesException;

}