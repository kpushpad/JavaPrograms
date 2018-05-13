package com.kpushpad.java.generics;

import java.util.ArrayList;
import java.util.List;


public class Generics {
	
	public static <T> void copy(List<? super T> dest, List<? extends T> src) { // bounded wildcard parameterized types
		for (int i = 0; i < src.size(); i++)
			dest.set(i, src.get(i));
	}

	public static void genrics() {
		List<?> list1 = new ArrayList<Object>();
		List<?> list2 = new ArrayList<Integer>();
		List<?> list3 = new ArrayList<Car>();
		
		// List<Object> list23 = new ArrayList<Integer>(); // Compilation Error

		// List<String> l = new ArrayList<Integer>(); // Compilation Error
		// List<String> l = new ArrayList<Object>(); // Compilation Error

		// producer
		List<? extends Number> list4 = new ArrayList<Integer>();
		List<? extends Number> list5 = new ArrayList<Double>();
		List<? extends Number> list6 = new ArrayList<Short>();
		List<? extends Number> list7 = new ArrayList<Number>();
		// List<? extends Number> l = new ArrayList<Object>(); // Compilation Error

		// Consumer
		List<? super Integer> list9 = new ArrayList<Integer>();
		List<? super Integer> list10 = new ArrayList<Number>();
		List<? super Integer> list11 = new ArrayList<Object>();

		// List<? super Integer> list12 = new ArrayList<Double>(); // Compilation Error

	}

	public class Box<T extends Comparable<T>> {
		private T t;
	}
	
   public class Box1<T> {
	   private T t;
		
	}
	public class Car {
	}

}
