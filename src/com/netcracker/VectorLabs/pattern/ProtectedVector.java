package com.netcracker.VectorLabs.pattern;

import java.util.ArrayList;
import java.util.Iterator;

import com.netcracker.VectorLabs.except.*;
import com.netcracker.VectorLabs.vector.Vector;
import com.netcracker.VectorLabs.vector.impl.JArrayListVector;
import com.netcracker.VectorLabs.pattern.Observer;

public class ProtectedVector implements Vector{
	private Vector vector;

	public ProtectedVector(Vector vector){
		this.vector=vector;
	}
	
	public void registerObserver(Observer obs){
    
    }
    
    public void removeObserver(Observer obs){
    
    }
    
    public void notifyElementChanged(int index) {
	
    }


	public void notifyObjectChanged() {
		
	}
	
	public void setElement(int i, double newValue) {
	}
	
	public double getElement(int i) {
		return vector.getElement(i);
	}

	
	public int getSize() {
		return vector.getSize();
	}
	
	public void populateWithArray(double[] array) throws IncompatibleVectorSizesException {
	
	}
	
	public void populateWithObject(Vector obj)throws IncompatibleVectorSizesException {

	}
	
	public void multiply(int x) {
	
	}
	
	public void add(Vector obj) throws IncompatibleVectorSizesException {
	
	}
	
	public boolean compare(Vector obj) throws IncompatibleVectorSizesException {
		return vector.compare(obj);
	}
	
	public Iterator iterator() {
		return vector.iterator();
	}
	public String toString(){
		return vector.toString();
	}
	
	public boolean equals(Object obj){
		return vector.equals(obj);
	}
	
	public int hashCode(){
		return vector.hashCode();
	}
	
	public ProtectedVector clone() throws CloneNotSupportedException{
		ProtectedVector newObject = (ProtectedVector) super.clone();
        newObject.vector = (Vector) this.vector.clone();
        return newObject;
	}
}

