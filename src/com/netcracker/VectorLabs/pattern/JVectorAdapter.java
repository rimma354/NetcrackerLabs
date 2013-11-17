package com.netcracker.VectorLabs.pattern;

import java.util.*;

import com.netcracker.VectorLabs.except.*;
import com.netcracker.VectorLabs.vector.Vector;
import com.netcracker.VectorLabs.pattern.Observer;

public class JVectorAdapter implements Vector {
    private java.util.Vector vector;
    private ArrayList<Observer> observers;

    public JVectorAdapter(java.util.Vector vector){
        this.vector=vector;
        observers = new ArrayList<Observer>();
    }
    
    public void registerObserver(Observer obs){
        	observers.add(obs);
    }
    
    public void removeObserver(Observer obs){
    	int i=observers.indexOf(obs);
    	if(i>=0){
    		observers.remove(i);
    	}
    }
    
    public void notifyElementChanged(int index) {
		for (Observer obs:observers){
			obs.elementChanged(index);
		}
	}


	public void notifyObjectChanged() {
		for (Observer obs:observers){
			obs.objectChanged();
		}
	}
    public void setElement(int i, double newValue){
       if (0 <= i && i < vector.size()) {
        vector.set(i,newValue);
       }
       else {
          throw new VectorIndexOutOfBoundsException();
       }
    }

    public double getElement(int i){
        return (Double)vector.get(i);
    }

    public int getSize(){
        return  vector.size();
    }

    public void populateWithArray(double[] array) throws IncompatibleVectorSizesException{
        try {

            if (this.getSize() == array.length) {
                for (int i = 0; i < this.getSize(); i++) {
                    setElement(i, array[i]);
                }
            } else {
                throw new IncompatibleVectorSizesException();
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public void populateWithObject(Vector obj) throws IncompatibleVectorSizesException{
        try {
            if (this.getSize() == obj.getSize()) {
                for (int i = 0; i < this.getSize(); i++) {
                    setElement(i, obj.getElement(i));
                }
            } else {
                throw new IncompatibleVectorSizesException();
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public void multiply(int x){
        for (int i = 0; i < this.getSize(); i++)
            setElement(i, this.getElement(i) * x);
    }

    public void add(Vector obj) throws IncompatibleVectorSizesException{
        try {
            if (this.getSize() == obj.getSize()) {
                for (int i = 0; i < this.getSize(); i++) {
                    setElement(i, this.getElement(i) + obj.getElement(i));
                }
            } else
                throw new IncompatibleVectorSizesException();
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public boolean compare(Vector obj) throws IncompatibleVectorSizesException{
        try {
            if (this.getSize() == obj.getSize()) {
                boolean dif = false;
                for (int i = 0; i < this.getSize(); i++) {
                    if (this.getElement(i) != obj.getElement(i)) {
                        dif = true;
                        break;
                    }
                }
                if (dif == false) {
                    return true;
                } else {
                    return false;
                }
            } else {
                throw new IncompatibleVectorSizesException();
            }
        } catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }

    public String toString(){
       return vector.toString();
    }

    public boolean equals(Object obj){
        if (obj instanceof Vector) {
            try {
                return this.compare((Vector) obj);
            } catch (IncompatibleVectorSizesException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    public int hashCode(){
        return vector.hashCode();
    }

    public Iterator iterator(){
        return vector.iterator();
    }

    public Object clone() throws CloneNotSupportedException{
    	JVectorAdapter object = (JVectorAdapter)super.clone();
        object.vector = (java.util.Vector)vector.clone();
        return object;
    }

}
