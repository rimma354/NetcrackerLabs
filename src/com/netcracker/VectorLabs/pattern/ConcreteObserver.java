package com.netcracker.VectorLabs.pattern;

import com.netcracker.VectorLabs.vector.Vector;

public class ConcreteObserver implements Observer{
	private Vector subject;
	
	public ConcreteObserver(Vector vector){
		this.subject=vector;
	}
	
	public void elementChanged(int index){
		System.out.println("Element number "+index+"changed");
	}
	
	public void objectChanged(){
		System.out.println("Some changes with object");
	}
}
