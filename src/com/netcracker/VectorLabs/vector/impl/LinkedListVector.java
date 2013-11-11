package com.netcracker.VectorLabs.vector.impl;

import java.util.*;
import java.io.*;

import com.netcracker.VectorLabs.except.*;
import com.netcracker.VectorLabs.vector.Vector;

public class LinkedListVector implements Vector, Cloneable {
    public int k = 0;
    private Link head;
    private Link tail;

    public LinkedListVector(double... value) {
        for (int i = 0; i < value.length; i++) {
            addLink(value[i]);
        }
    }

    public int getSize() {
        return this.k;
    }

    public void addLink(double newValue) {
        if (getSize() == 0) {
            Link first = new Link(newValue);
            head = first;
            tail = first;
            k++;
        } else {
            if (getSize() == 1) {
                Link second = new Link(newValue);
                second.prev = tail;
                second.next = head;
                tail = second;
                head.next = second;
                head.prev = tail;
                k++;
            } else {
                Link newLink = new Link(newValue);
                tail.next = newLink;
                newLink.prev = tail;
                newLink.next = head;
                tail = newLink;
                head.prev = tail;
                k++;
            }
        }
    }

    public void deleteLink() {
        if (getSize() == 0) {
            throw new NoSuchElementException();
        } else {
            if (getSize() == 1) {
                head = null;
                tail = null;
                k--;
            } else {
                tail = tail.prev;
                tail.next = head;
                k--;
            }
        }
    }

    public double getElement(int i) {
        if (0 <= i && i < getSize()) {
            Link t = head;
            for (int j = 0; j < i; j++) {
                t = t.next;
            }
            return t.value;
        } else {
            throw new VectorIndexOutOfBoundsException();
        }
    }

    public void setElement(int i, double newValue) {
        if (0 <= i && i < getSize()) {
            Link t = head;
            for (int j = 0; j < i; j++) {
                t = t.next;
            }
            t.value = newValue;
        } else {
            throw new VectorIndexOutOfBoundsException();
        }
    }

    public void multiply(int x) {
        for (int j = 0; j < this.getSize(); j++)
            setElement(j, this.getElement(j) * x);
    }

    public void print() {
        Link t = head;
        for (int i = 0; i < this.getSize(); i++) {
            System.out.println(t.value);
            t = t.next;
        }
    }

    public void populateWithArray(double[] array) throws IncompatibleVectorSizesException {
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

    public void populateWithObject(Vector obj) throws IncompatibleVectorSizesException {
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

    public void add(Vector obj) throws IncompatibleVectorSizesException {
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
            return  false;
        }
    }

    public String toString() {
        String s = new String();
        StringBuffer sb = new StringBuffer("List-vector consists from " + this.getSize() + " elements and its elements are:");
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

    public LinkedListVector clone() throws CloneNotSupportedException {
        LinkedListVector newObject = (LinkedListVector) super.clone();
        newObject.k = 0;
        newObject.head = null;
        newObject.tail = null;
        for (int i = 0; i < this.k; i++) {
            newObject.addLink(this.getElement(i));
        }
        return newObject;
    }


    class Link implements Serializable {
        private Link prev;
        private Link next;
        private double value;

        Link(double newValue) {
            value = newValue;
            prev = this;
            next = this;
        }
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
