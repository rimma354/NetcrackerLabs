package com.netcracker.VectorLabs.vector.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.netcracker.VectorLabs.except.IncompatibleVectorSizesException;

public class TestArrayVector {
	ArrayVector obj1;
	ArrayVector obj2;
	ArrayVector obj3;
	
	@Before
	public void setUp() throws Exception {
	obj1= new ArrayVector(4);
	obj2=new ArrayVector(1,2,3,4);
	obj3=new ArrayVector(4,2,1,3);
	}

	@Test
	public void testGetSize() {
		int res1=obj1.getSize();
		int res2=obj2.getSize();
		assertEquals(4,res1);
		assertEquals(4,res2);
	}
	
	@Test
	public void testGetElement() {
		double res1=obj1.getElement(1);
		double res2=obj2.getElement(1);
		assertEquals(0,res1,0);
		assertEquals(2.0,res2,0);
	}
	
	@Test
	public void testSetElement() {
		obj1.setElement(0,1);
		obj2.setElement(0,10);
		assertEquals(1,obj1.elements[0],0);
		assertEquals(10,obj2.elements[0],0);
	}
	
	@Test
	public void testPopulateWithArray() throws IncompatibleVectorSizesException {
		double[]ar={8,8,8,8};
		obj1.populateWithArray(ar);
		assertArrayEquals(ar, obj1.elements, 0);
	}
	
	@Test
	public void testPopulateWithObject() throws IncompatibleVectorSizesException {
		obj1.populateWithObject(obj2);
		assertArrayEquals(obj2.elements, obj1.elements, 0);
	}
	
	@Test
	public void testCompare() throws IncompatibleVectorSizesException {
		ArrayVector obj4=new ArrayVector(1,2,3,4);
		boolean res1=obj2.compare(obj1);
		boolean res2=obj2.compare(obj4);
		assertFalse(res1==true);
		assertTrue(res2==true);
	}
	
	@Test
	public void testMultiply()  {
		ArrayVector obj4=new ArrayVector(2,4,6,8);
		obj2.multiply(2);
		assertEquals(obj4,obj2);
	}
	
	@Test
	public void testAdd() throws IncompatibleVectorSizesException  {
		ArrayVector obj4=new ArrayVector(1,1,1,1);
		ArrayVector a=new ArrayVector(2,3,4,5);
		obj2.add(obj4);
		assertEquals(a,obj2);
	}
	
	@Test
	public void testToString() {
		String s1="Array-vector consists from 4 elements and its elements are: 1.0 2.0 3.0 4.0";
		String s2=obj2.toString();
		assertEquals(s1, s2);
	}

}
