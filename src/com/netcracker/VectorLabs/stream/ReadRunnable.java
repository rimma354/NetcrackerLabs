package com.netcracker.VectorLabs.stream;

public class ReadRunnable implements Runnable{
	 private Keeper vector;
	 
     public ReadRunnable (Keeper k){
    	 this.vector = k;
     }
     
     public void run(){
         try {  
             readElement();
         } catch (InterruptedException ex) {
             
         }
     }

	private void readElement() throws InterruptedException{
		for (int i =0;i <vector.getVector().getSize(); i++) {
			vector.getElement(i);
		    // System.out.println("Read: " + vector.getElement(i) + " from position " + i);  
		}
	}
 

}
