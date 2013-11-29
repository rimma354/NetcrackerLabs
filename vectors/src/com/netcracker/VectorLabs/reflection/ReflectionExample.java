package com.netcracker.VectorLabs.reflection;

import java.lang.reflect.*;

public class ReflectionExample {
	public static void main(String[]args){
		if (args.length == 4) {
			try {
			Class c = Class.forName(args[0]);
			Method method = c.getMethod(args[1], new Class [] {Double.TYPE,Double.TYPE});
			Double value1 = Double.valueOf(args[2]);
			Double value2 = Double.valueOf(args[3]);
			Object res = method.invoke(null, new Object [] {value1,value2});
			System.out.println(res.toString());
			} catch (ClassNotFoundException e) {
			System.out.println("Класс не найден");
			} catch (NoSuchMethodException e) {
			System.out.println("Метод не найден");
			} catch (IllegalAccessException e) {
			System.out.println("Метод недоступен");
			} catch (InvocationTargetException e) {
			System.out.println("При вызове возникло исключение");
			}
			}
	}

}
 