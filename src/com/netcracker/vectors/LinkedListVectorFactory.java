package com.netcracker.vectors;

/**
 * Created with IntelliJ IDEA.
 * User: Rimma
 * Date: 24.10.13
 * Time: 19:14
 * To change this template use File | Settings | File Templates.
 */
public class LinkedListVectorFactory implements VectorFactory{
    public Vector createVector(){
        Vector v=new LinkedListVector();
        return v;
    }
    public Vector createVectorWithSize(int newSize){
        LinkedListVector v=new LinkedListVector();
            for (int i=0; i<newSize; i++){
             v.addLink(0);
         }


        return v;
    }
}
