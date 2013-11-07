package com.netcracker.vectors;


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
