package com.netcracker.vectors;

/**
 * Created with IntelliJ IDEA.
 * User: Rimma
 * Date: 31.10.13
 * Time: 18:08
 * To change this template use File | Settings | File Templates.
 */
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
