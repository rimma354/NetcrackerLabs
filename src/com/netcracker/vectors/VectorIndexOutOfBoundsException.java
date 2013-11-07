package com.netcracker.vectors;


public class VectorIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public VectorIndexOutOfBoundsException(String str){
        super(str);
    }
    public VectorIndexOutOfBoundsException(){
     super();
     }
    public String toString(){
        return "VectorIndexOutOfBoundsException ";
    }
}
