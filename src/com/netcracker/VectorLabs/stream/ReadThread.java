package com.netcracker.VectorLabs.stream;

import java.util.Random;

import com.netcracker.VectorLabs.vector.Vector;

public class ReadThread extends Thread{
	private Vector vector;
	
	public ReadThread(Vector v){
		this.vector=v;
		start();
	}
	
	public void run(){
		readVector();
	}

	private void readVector() {
		for (int i =0;i <vector.getSize(); i++) {
			System.out.println("Read: " + vector.getElement(i) + " from position " + i);  
		}
	}

}
