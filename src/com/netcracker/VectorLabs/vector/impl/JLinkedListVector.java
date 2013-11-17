package com.netcracker.VectorLabs.vector.impl;

import java.util.*;

import com.netcracker.VectorLabs.except.*;
import com.netcracker.VectorLabs.vector.Vector;
import com.netcracker.VectorLabs.pattern.Observer;

public class JLinkedListVector implements Vector, Cloneable {
    private LinkedList<Double> elements;
    private ArrayList<Observer> observers;

    public JLinkedListVector(int newSize) {
        elements = new LinkedList<Double>();
        for (int i = 0; i < newSize; i++) {
            this.elements.add(i, null);
        }

    }

    public JLinkedListVector(double... value) {
        elements = new LinkedList<Double>();
        for (int i = 0; i < value.length; i++) {
            elements.add(i, value[i]);
        }
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

    public int getSize() {
        return this.elements.size();
    }

    public double getElement(int i) {
        if (0 <= i && i < getSize()) {
            return this.elements.get(i);
        } else {
            throw new VectorIndexOutOfBoundsException();
        }
    }

    public void setElement(int i, double newValue) {
        if (0 <= i && i < getSize()) {
            this.elements.set(i, newValue);
            notifyElementChanged(i);
        } else {
            throw new VectorIndexOutOfBoundsException();
        }
    }

    public void print() {
        for (int i = 0; i < this.getSize(); i++) {
            System.out.println(this.elements.get(i));
        }
    }

    public void populateWithArray(double[] array) throws IncompatibleVectorSizesException {
        try {
            if (this.getSize() == array.length) {
                for (int i = 0; i < this.getSize(); i++){
                    setElement(i, array[i]);
                }
                notifyObjectChanged();
            } else {
                throw new IncompatibleVectorSizesException();
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public void populateWithObject(Vector obj) throws IncompatibleVectorSizesException {
        try {
            if (this.getSize() == obj.getSize()) {
                for (int i = 0; i < this.getSize(); i++) {
                    setElement(i, obj.getElement(i));
                }
                notifyObjectChanged();
            } else {
                throw new IncompatibleVectorSizesException();
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }


    public boolean compare(Vector obj) throws IncompatibleVectorSizesException {
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

    public void multiply(int x) {
        for (int i = 0; i < this.getSize(); i++){
            setElement(i, this.getElement(i) * x);
        }
        notifyObjectChanged();
    }

    public void add(Vector obj) throws IncompatibleVectorSizesException {
        try {
            if (this.getSize() == obj.getSize()) {
                for (int i = 0; i < this.getSize(); i++) {
                    setElement(i, this.getElement(i) + obj.getElement(i));
                }
                notifyObjectChanged();
            } else
                throw new IncompatibleVectorSizesException();
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public String toString() {
        String s = new String();
        StringBuffer sb = new StringBuffer("List-vector(collection) consists from " + this.getSize() + " elements and its elements are:");
        for (int i = 0; i < this.getSize(); i++)
            sb = sb.append(" ").append(this.getElement(i));
        s = sb.toString();
        return s;
    }

    public boolean equals(Object obj) {
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

    public int hashCode() {
        int result = 0;
        for (int i = 0; i < this.getSize(); i++) {
            long b = Double.doubleToRawLongBits(this.getElement(i));
            result ^= ((int) (b & 0x00000000FFFFFFFFL)) ^ ((int) ((b & 0xFFFFFFFF00000000L) >> 32));
        }
        return result;
    }

    public JLinkedListVector clone() throws CloneNotSupportedException {
        JLinkedListVector newObject = (JLinkedListVector) super.clone();
        newObject.elements = (LinkedList) this.elements.clone();
        return newObject;
    }

    public Iterator iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<Double> {
        private int count = 0;

        public boolean hasNext() {
            if (count < getSize()) {
                return true;
            } else {
                return false;
            }
        }

        public Double next() {
            if (count == getSize()) {
                throw new NoSuchElementException();
            } else {
                count++;
                return getElement(count - 1);
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
