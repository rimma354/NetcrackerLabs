package com.netcracker.vectors;

import java.util.*;

public class JVectorAdapter implements Vector {
    java.util.Vector vector;

    public JVectorAdapter(java.util.Vector vector){
        this.vector=vector;
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

    public void print(){
        for (int i=0; i<this.getSize();i++) {
            System.out.println(this.getElement(i));
        }
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

    public Vector clone() throws CloneNotSupportedException{
        return (Vector)vector.clone();
    }
}
