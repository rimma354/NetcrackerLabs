package com.netcracker.vectors;
import java.util.*;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Rimma
 * Date: 24.10.13
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */

public class JArrayListVector implements Vector, Cloneable{
    private ArrayList<Double> elements;


    public JArrayListVector(int newSize) {
        elements=new ArrayList<Double>();
        for (int i=0; i<newSize; i++){
            this.elements.add(i,null);

        }

    }
    public JArrayListVector(double ...value) {
        elements=new ArrayList<Double>();
        for (int i=0; i<value.length; i++)  {
            elements.add(i,null);
            setElement(i,value[i]);
        }
    }
    public int getSize() {
        return this.elements.size();
    }
    public double getElement(int i){
        return this.elements.get(i);
    }
    public void setElement(int i, double newValue) {
        this.elements.set(i,newValue);
    }
    public void print() {
        for (int i = 0; i < this.getSize(); i++) {
            System.out.println(this.elements.get(i));
        }
    }

    public void populateWithArray(double[] array) {
        if (this.getSize() == array.length) {
            for (int i = 0; i < this.getSize(); i++)
                setElement(i,array[i]);
        } else {
            System.out.println("You can't do this, because array doesn't fit to vector's size!");
        }
    }
    public void populateWithObject(Vector obj) {
        if (this.getSize() == obj.getSize()) {
            for (int i = 0; i < this.getSize(); i++) {
                setElement(i, obj.getElement(i));
            }
        } else {
            System.out.println("You can't do this, because objects have different size!");
        }
    }


    public void compare(Vector obj) {
        if (this.getSize() == obj.getSize()) {
            boolean dif = false;
            for (int i = 0; i < this.getSize(); i++) {
                if (this.getElement(i) != obj.getElement(i)) {
                    dif = true;
                    break;
                }
            }
            if (dif == false)
                System.out.println("Vectors are equal!");
            else
                System.out.println("Vectors have different elements!");
        } else {
            System.out.println("Vectors have different size!");
        }
    }
    public void multiply(int x) {

        for (int i = 0; i < this.getSize(); i++)
            setElement(i, this.getElement(i) * x);

    }
    public void add(Vector obj) {

        if (this.getSize() == obj.getSize()) {
            for (int i = 0; i < this.getSize(); i++) {
                setElement(i, this.getElement(i) + obj.getElement(i));
            }
        } else
            System.out.println("Vectors have different size, you can't add them!");

    }
    public String toString() {
        String s = new String();
        StringBuffer sb = new StringBuffer("Array-vector consists from " + this.getSize() + " elements and its elements are:");
        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i < this.getSize(); i++)
            sb2 = sb2.append(" ").append(this.getElement(i));
        s = sb.append(sb2).toString();
        return s;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Vector) {
            if (this.getSize() == ((Vector) obj).getSize()) {
                boolean dif = false;
                for (int i = 0; i < this.getSize(); i++) {
                    if (this.getElement(i) != ((Vector) obj).getElement(i)) {
                        dif = true;
                        break;
                    }
                }
                if (dif == false)  {
                    System.out.println("Vectors are equal!");
                    return true;
                }else {
                    System.out.println("Vectors have different elements!");
                    return false;
                } } else {
                System.out.println("Vectors have different size!");
            }

        } else {
            System.out.println("Different objects");
            return false;
        }
        return false;
    }
    public int hashCode(){
        int result = 0;
        for (int i=0; i<this.getSize();i++) {
            long b = Double.doubleToRawLongBits(this.getElement(i));
            result ^= ((int)(b & 0x00000000FFFFFFFFL)) ^ ((int)((b & 0xFFFFFFFF00000000L) >> 32));
        }
        return result;
    }
    public JArrayListVector clone(){
        JArrayListVector newObject= null;
        try {
            newObject = (JArrayListVector) super.clone();
            newObject.elements= (ArrayList) this.elements.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return newObject;
    }

    public Iterator iterator() {
        return new MyIterator();
    }
    class MyIterator implements Iterator<Double> {
        private int count=0;
        public boolean hasNext() {
            if(count <getSize()) return true;
            return false;
        }
        public Double next() {
            if(count ==getSize())
                throw new NoSuchElementException();

            count++;
            return getElement(count-1);

        }

        public void remove () {
            throw new UnsupportedOperationException();
        }
    }
}
