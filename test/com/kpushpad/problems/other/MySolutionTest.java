package com.kpushpad.problems.other;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MySolutionTest {

	@Test
	public void test() {
		String str = "00100101";
		
		ArrayList<ArrayList<Integer>> l = MySolution.countNumberOfSubString(str);
		
		MySolution.printAllSubString(str, l);
	}

	@Test
	public void testA() {
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(2);l.add(3); l.add(4); l.add(6);
		int sum= 0;
	
		
	}
	
	@Test 
	public void misc() {
		Integer a=10;
		System.out.println(a.compareTo(11));
	}
}
