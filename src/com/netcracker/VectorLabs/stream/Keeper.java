package com.netcracker.VectorLabs.stream;

import com.netcracker.VectorLabs.vector.Vector;

public class Keeper {
		private Vector vector;
		private boolean newed = false;
		
		public Keeper(Vector v){
			this.vector=v;
		}
		
		public Vector getVector(){
			return vector;
		}
		
		synchronized public void putElement(int i,double val) throws InterruptedException {
			while(newed)
				wait();
			vector.setElement(i, val);
			newed = true;
			//
			System.out.println("Write: " + val + " to position " + i);
			notifyAll();
		}
		
		synchronized public double getElement(int i) throws InterruptedException {
			while(!newed)
				wait();
			newed = false;
			//
			System.out.println("Read: " + vector.getElement(i) + " from position " + i);  
			notifyAll();
			return vector.getElement(i);
		}
		
}
