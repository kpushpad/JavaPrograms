package com.kpushpad.problems.other;

import java.util.ArrayList;
import java.util.List;

public class MySolution {
	
	
	public static void main(String args[]) {
		B b = (B) new A();
		b.m1();
	}
	
	public static ArrayList<ArrayList<Integer>> countNumberOfSubString(String str) {
		ArrayList<ArrayList<Integer>> solutionList = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> listWithOne = new ArrayList<Integer>();
		
		for (int i=0; i < str.length() ; i++) {
			if ('1' == str.charAt(i)) {
				 int endIdx = i;
				 for(Integer startIdx: listWithOne) {
					 ArrayList<Integer> l = new ArrayList<Integer>();
					 l.add(startIdx);
					 l.add(endIdx);
					 solutionList.add(l);
				 }
				 listWithOne.add(i);
			}
		}
		return solutionList;
	}

	public static void printAllSubString(String str, ArrayList<ArrayList<Integer>> list) {
		
		List<String> a = new ArrayList<String>();
				
		for(ArrayList<Integer> l: list) {
			System.out.println(str.substring(l.get(0), l.get(1)+1));
		}
		
	}
}

class A {
	
	void m1 () {
		System.out.println("a.m1");
	}

}

class B extends A {
	void m1 () {
		System.out.println("B.m1");
	}
	void m2() {
		System.out.println("a.m2");	
	}
}