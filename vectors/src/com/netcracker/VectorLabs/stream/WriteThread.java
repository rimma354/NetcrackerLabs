package com.netcracker.VectorLabs.stream;

import com.netcracker.VectorLabs.vector.Vector;
import java.util.Random;

public class WriteThread extends Thread{
	private Vector vector;
	
	public WriteThread(Vector v){
		this.vector=v;
		start();
	}
	
	public void run(){
		writeVector();
	}
	
	public void writeVector(){
		Random r=new Random();
		double randVal;
		for (int i = 0; i < vector.getSize(); i++){
			randVal=r.nextDouble();
			vector.setElement(i, randVal);
			System.out.println("Write: " + randVal + " to position " + i);
		}
	}

}
