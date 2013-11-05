package com.netcracker.vectors;

/**
 * Created with IntelliJ IDEA.
 * User: Rimma
 * Date: 31.10.13
 * Time: 18:21
 * To change this template use File | Settings | File Templates.
 */
public class IncompatibleVectorSizesException extends Exception{
    public IncompatibleVectorSizesException(String str){
        super(str);
    }
    public IncompatibleVectorSizesException(){
        super();
    }
    public String toString(){
        return "IncompatibleVectorSizesException";
    }
}
