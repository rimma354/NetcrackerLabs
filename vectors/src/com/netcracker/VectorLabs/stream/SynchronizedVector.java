package com.netcracker.VectorLabs.stream;

import java.util.ArrayList;
import java.util.Iterator;

import com.netcracker.VectorLabs.except.*;
import com.netcracker.VectorLabs.vector.Vector;
import com.netcracker.VectorLabs.vector.impl.JArrayListVector;
import com.netcracker.VectorLabs.pattern.Observer;

public class SynchronizedVector implements Vector{
	private Vector vector;

	public SynchronizedVector(Vector vector){
		this.vector=vector;
	}
	
	public synchronized void registerObserver(Observer obs){
		vector.registerObserver(obs);
    }
    
    public synchronized void removeObserver(Observer obs){
    	vector.removeObserver(obs);
    }
    
    public synchronized void notifyElementChanged(int index) {
    	vector.notifyElementChanged(index);
    }


	public synchronized void notifyObjectChanged() {
		vector.notifyObjectChanged();
	}
	
	public synchronized void setElement(int i, double newValue) {
		vector.setElement(i, newValue);
	}
	
	public synchronized double getElement(int i) {
		return vector.getElement(i);
	}

	
	public synchronized int getSize() {
		return vector.getSize();
	}
	
	public synchronized void populateWithArray(double[] array) throws IncompatibleVectorSizesException {
		vector.populateWithArray(array);
	}
	
	public synchronized void populateWithObject(Vector obj)throws IncompatibleVectorSizesException {
		vector.populateWithObject(obj);
	}
	
	public synchronized void multiply(int x) {
		vector.multiply(x);
	}
	
	public synchronized void add(Vector obj) throws IncompatibleVectorSizesException {
		vector.add(obj);
	}
	
	public synchronized boolean compare(Vector obj) throws IncompatibleVectorSizesException {
		return vector.compare(obj);
	}
	
	public synchronized Iterator iterator() {
		return vector.iterator();
	}
	public synchronized String toString(){
		return vector.toString();
	}
	
	public synchronized boolean equals(Object obj){
		return vector.equals(obj);
	}
	
	public synchronized int hashCode(){
		return vector.hashCode();
	}
	
	public synchronized SynchronizedVector clone() throws CloneNotSupportedException{
		SynchronizedVector newObject = (SynchronizedVector) super.clone();
        newObject.vector = (Vector) this.vector.clone();
        return newObject;
	}
}