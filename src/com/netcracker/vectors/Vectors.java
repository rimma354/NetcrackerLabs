package com.netcracker.vectors;

import java.util.*;
import java.io.*;

public class Vectors {

    private static VectorFactory currentVectorFactory = new ArrayVectorFactory();

    public static void setVectorFactory(VectorFactory factory) {
        currentVectorFactory = factory;
    }

    public static Vector createInstance(int size) {
        Vector v = currentVectorFactory.createVectorWithSize(size);
        return v;
    }

    public static Vector createInstance() {
        Vector v = currentVectorFactory.createVector();
        return v;
    }

    static void outputVector(Vector v, OutputStream out) {
        try {
            DataOutputStream outd = new DataOutputStream(out);
            outd.writeInt(v.getSize());
            for (int i = 0; i < v.getSize(); i++) {
                outd.writeDouble(v.getElement(i));
            }
            outd.flush();
        } catch (IOException e) {
            System.out.println("Some error occurred!");
        }

    }

    static Vector inputVector(InputStream in) {
        Vector v = null;
        try {
            DataInputStream ind = new DataInputStream(in);
            int n = ind.readInt();
            v = createInstance(n);

            for (int i = 0; i < v.getSize(); i++) {
                v.setElement(i, ind.readDouble());
            }

        } catch (IOException e) {
            System.out.println("Some error occurred!");

        }
        return v;
    }

    static void writeVector(Vector v, Writer out) {
        try {
            PrintWriter outw = new PrintWriter(out);
            outw.print(v.getSize());
            for (int i = 0; i < v.getSize(); i++) {
                outw.print(" " + v.getElement(i));
            }
            outw.print('\n');
            outw.flush();
        } catch (Exception ex) {
            System.out.println("Some error occurred!");

        }
    }

    static Vector readVector(Reader in) {
        Vector v = null;
        try {
            StreamTokenizer ind = new StreamTokenizer(in);
            ind.nextToken();
            v = createInstance((int) ind.nval);

            for (int i = 0; i < v.getSize(); i++) {
                ind.nextToken();

                v.setElement(i, ind.nval);
            }
        } catch (IOException e) {
            System.out.println("Some error occurred!");

        }
        return v;
    }

    static double[] createArray(int newSize) {
        Random r = new Random();
        double[] newArray = new double[newSize];
        for (int i = 0; i < newSize; i++)
            newArray[i] = r.nextDouble();
        return newArray;
    }

    static Vector multiply(Vector obj, int x) {
        Vector m = createInstance(obj.getSize());

        for (int i = 0; i < obj.getSize(); i++) {
            m.setElement(i, obj.getElement(i) * x);
        }
        return m;
    }

    static Vector add(Vector obj1, Vector obj2) throws IncompatibleVectorSizesException{


        if ((obj1!=null)&&(obj2!=null)){
            Vector ad = createInstance(obj1.getSize());
            if (obj1.getSize() == obj2.getSize()) {
                for (int i = 0; i < obj1.getSize(); i++) {
                    ad.setElement(i, obj1.getElement(i) + obj2.getElement(i));
                }
                return ad;
            } else
            {
                throw new IncompatibleVectorSizesException();
            }
        }
        else {
            throw new IllegalArgumentException();
        }

        }


    static Vector sort(Vector obj) {
       if (obj!=null){
        Vector s = createInstance(obj.getSize());
        for (int i = 0; i < s.getSize(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < s.getSize(); j++) {
                if (s.getElement(j) < s.getElement(minIndex)) {
                    minIndex = j;
                }
            }
            double temp = s.getElement(i);
            s.setElement(i, obj.getElement(minIndex));
            s.setElement(minIndex, temp);

        }
        return s;
    }
        else {
           throw new IllegalArgumentException();
       }

}
}