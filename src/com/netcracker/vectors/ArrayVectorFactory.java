package com.netcracker.vectors;

/**
 * Created with IntelliJ IDEA.
 * User: Rimma
 * Date: 24.10.13
 * Time: 19:09
 * To change this template use File | Settings | File Templates.
 */
public class ArrayVectorFactory implements VectorFactory {
   public Vector createVector(){
    Vector v=new ArrayVector();
    return v;
    }
    public Vector createVectorWithSize(int newSize){
    Vector v=new ArrayVector(newSize);
    return v;
    }
}