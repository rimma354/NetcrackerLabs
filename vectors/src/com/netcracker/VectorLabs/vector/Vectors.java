package com.netcracker.VectorLabs.vector;

import java.util.*;
import java.io.*;
import java.lang.reflect.*;

import com.netcracker.VectorLabs.except.*;
import com.netcracker.VectorLabs.pattern.*;
import com.netcracker.VectorLabs.pattern.factory.*;
import com.netcracker.VectorLabs.stream.SynchronizedVector;

public class Vectors {
	public static Vector getProtectedVector(Vector vector) {
		return new ProtectedVector(vector);
	}

	public static Vector getAdaptedJVector(java.util.Vector jVector) {
		Vector utilVectorAdapted = new JVectorAdapter(jVector);
		return utilVectorAdapted;

	}

	private static VectorFactory currentVectorFactory = new ArrayVectorFactory();

	public static void setVectorFactory(VectorFactory factory) {
		currentVectorFactory = factory;
	}

	public static Vector createInstance(int size) {
		Vector v = currentVectorFactory.createVectorWithSize(size);
		return v;
	}

	public static Vector createInstance() {
		Vector v = currentVectorFactory.createVector();
		return v;
	}

	public static Vector createInstance(Vector v, int size) {
		Object res = null;
		try {
			Class c = v.getClass();
			Constructor[] constr = c.getConstructors();
			Class[] param = new Class[] { int.class };
			Constructor myConstr = c.getConstructor(param);
			res = myConstr.newInstance(size);

		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			System.out.println("Метод недоступен");
		} catch (IllegalArgumentException ex) {
			return currentVectorFactory.createVectorWithSize(size);
		} catch (InvocationTargetException ex) {
			System.out.println("При вызове возникло исключение");
		} catch (NoSuchMethodException ex) {
			System.out.println("Метод не найден");
		}
		return (Vector) res;
	}

	static void outputVector(Vector v, OutputStream out) {
		try {
			DataOutputStream outd = new DataOutputStream(out);
			outd.writeInt(v.getSize());
			for (int i = 0; i < v.getSize(); i++) {
				outd.writeDouble(v.getElement(i));
			}
			outd.flush();
		} catch (IOException e) {
			System.out.println("Some error occurred!");
		}

	}

	static Vector inputVector(InputStream in) {
		Vector v = null;
		try {
			DataInputStream ind = new DataInputStream(in);
			int n = ind.readInt();
			v = createInstance(n);
			for (int i = 0; i < v.getSize(); i++) {
				v.setElement(i, ind.readDouble());
			}
		} catch (IOException e) {
			System.out.println("Some error occurred!");
		}
		return v;
	}

	static void writeVector(Vector v, Writer out) {
		try {
			PrintWriter outw = new PrintWriter(out);
			outw.print(v.getSize());
			for (int i = 0; i < v.getSize(); i++) {
				outw.print(" " + v.getElement(i));
			}
			outw.print('\n');
			outw.flush();
		} catch (Exception ex) {
			System.out.println("Some error occurred!");
		}
	}

	static Vector readVector(Reader in) {
		Vector v = null;
		try {
			StreamTokenizer ind = new StreamTokenizer(in);
			ind.nextToken();
			v = createInstance((int) ind.nval);
			for (int i = 0; i < v.getSize(); i++) {
				ind.nextToken();
				v.setElement(i, ind.nval);
			}
		} catch (IOException e) {
			System.out.println("Some error occurred!");
		}
		return v;
	}

	static double[] createArray(int newSize) {
		Random r = new Random();
		double[] newArray = new double[newSize];
		for (int i = 0; i < newSize; i++)
			newArray[i] = r.nextDouble();
		return newArray;
	}

	static Vector multiply(Vector obj, int x) {
		Vector m = createInstance(obj.getSize());
		for (int i = 0; i < obj.getSize(); i++) {
			m.setElement(i, obj.getElement(i) * x);
		}
		return m;
	}

	static Vector add(Vector obj1, Vector obj2)
			throws IncompatibleVectorSizesException {
		try {
			Vector ad = createInstance(obj1.getSize());
			if (obj1.getSize() == obj2.getSize()) {
				for (int i = 0; i < obj1.getSize(); i++) {
					ad.setElement(i, obj1.getElement(i) + obj2.getElement(i));
				}
				return ad;
			} else {
				throw new IncompatibleVectorSizesException();
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

	static Vector sort(Vector obj) {
		try {
			Vector s = createInstance(obj.getSize());
			for (int i = 0; i < s.getSize(); i++) {
				int minIndex = i;
				for (int j = i + 1; j < s.getSize(); j++) {
					if (s.getElement(j) < s.getElement(minIndex)) {
						minIndex = j;
					}
				}
				double temp = s.getElement(i);
				s.setElement(i, obj.getElement(minIndex));
				s.setElement(minIndex, temp);
			}
			return s;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

	static public Vector synchronizedVector(Vector vector) {
		return new SynchronizedVector(vector);
	}
}