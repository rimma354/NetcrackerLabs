package com.netcracker.VectorLabs.stream;

import java.util.Random;

public class WriteRunnable implements Runnable{
	private Keeper vector;
	 
    public WriteRunnable (Keeper k){
   	 	this.vector = k;
    }
    
	public void run() {
		try {  
            writeElement();
        } catch (InterruptedException ex) {
            
        }
	}

	private void writeElement() throws InterruptedException {
		Random r=new Random();
		double randVal;
		for (int i = 0; i < vector.getVector().getSize(); i++){
			randVal=r.nextDouble();
			vector.putElement(i, randVal);
			//System.out.println("Write: " + randVal + " to position " + i);
		}
		
	}

}
