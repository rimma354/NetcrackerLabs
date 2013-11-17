package com.netcracker.VectorLabs.vector.impl;

import java.util.*;

import com.netcracker.VectorLabs.except.*;
import com.netcracker.VectorLabs.pattern.Observer;
import com.netcracker.VectorLabs.vector.Vector;

public class ArrayVector implements Vector, Cloneable {
    private double[] elements;
    private ArrayList<Observer> observers;

    public ArrayVector(int newSize) {
        this.setElements(new double[newSize]);
        observers = new ArrayList<Observer>();
    }

    public ArrayVector(double... value) {
        this.setElements(new double[value.length]);
        observers = new ArrayList<Observer>();
        for (int i = 0; i < value.length; i++) {
            setElement(i, value[i]);
        }
      
    }
    
    public double[] getElements() {
		return elements;
	}

	public void setElements(double[] elements) {
		this.elements = elements;
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
        return this.getElements().length;
    }

    public void setElement(int i, double newValue) {
        if ((0 <= i) & (i < getSize())) {
            this.getElements()[i] = newValue;
            notifyElementChanged(i);
        } else {
            throw new VectorIndexOutOfBoundsException();
        }
    }

    public double getElement(int i) {
        if ((0 <= i) & (i < getSize())) {
            return this.getElements()[i];
        } else {
            throw new VectorIndexOutOfBoundsException();
        }
    }

    public void populateWithArray(double[] array) throws IncompatibleVectorSizesException {
        try {
            if (this.getSize() == array.length) {
                for (int i = 0; i < this.getSize(); i++) {
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
            } else  {
                throw new IncompatibleVectorSizesException();
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public String toString() {
        String s = new String();
        StringBuffer sb = new StringBuffer("Array-vector consists from " + this.getSize() + " elements and its elements are:");
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

    public ArrayVector clone() throws CloneNotSupportedException {
        ArrayVector newObject = (ArrayVector) super.clone();
        newObject.setElements(this.getElements().clone());
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
