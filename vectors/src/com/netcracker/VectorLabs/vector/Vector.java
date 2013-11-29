package com.netcracker.VectorLabs.vector;

import java.util.*;
import java.io.*;

import com.netcracker.VectorLabs.except.*;
import com.netcracker.VectorLabs.pattern.Observer;

public interface Vector extends Serializable, Iterable<Double> {
    public void setElement(int i, double newValue);

    public double getElement(int i);

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

    public Object clone() throws CloneNotSupportedException;
    
    public void notifyElementChanged(int index);
    
    public void notifyObjectChanged();
    
    public void registerObserver(Observer obs);
    
    public void removeObserver(Observer obs);

	
}