package com.netcracker.VectorLabs.vector;

import com.netcracker.VectorLabs.except.IncompatibleVectorSizesException;

import com.netcracker.VectorLabs.stream.*;
import com.netcracker.VectorLabs.vector.impl.*;

public class Main {
	public static void main(String[] args){
		Vector o1 = new ArrayVector(2);
        Vector o2 = new ArrayVector(3);
        Vector o3 = new ArrayVector(4);
        
     /*  WriteThread w1=new WriteThread(o1);

        WriteThread w2=new WriteThread(o2);

        WriteThread w3=new WriteThread(o3);*/
  
        
       /* ReadThread r1=new ReadThread(o1);
        ReadThread r2=new ReadThread(o2);
        ReadThread r3=new ReadThread(o3);*/
        
        Keeper k = new Keeper(o3);
        Runnable rr = new ReadRunnable(k);
        Runnable wr = new WriteRunnable(k);
        Thread t1 = new Thread(wr);
        Thread t2 = new Thread(rr);
        t1.start();
        t2.start();
	}

}
