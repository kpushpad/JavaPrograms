package com.kpushpad.problems.backtraking;

import java.util.ArrayList;
import java.util.List;

import com.kpushpad.problems.backtraking.SumSubSet;

import org.junit.Assert;
import org.junit.Test;

public class SumSubSetTest {

	@Test
	public void testA() {
		int[] A = { 4, 5, 9, 8, 1 };
		List<ArrayList<Integer>> results = SumSubSet.calAllSetForGivemSum(A, 9);
		SumSubSet.printAllSolution(results);
		Assert.assertEquals(3, results.size());
	}

	@Test
	public void testB() {
		int[] A = { 1, 2, 3, 4, 10, 6, 7, 8, 9 };
		List<ArrayList<Integer>> results = SumSubSet.calAllSetForGivemSum(A, 10);
		SumSubSet.printAllSolution(results);
		Assert.assertEquals(8, results.size());
	}

	@Test
	public void testC() {
		// Element has to be sorted 
		int[] A = { 1, 2, 3, 4, 6, 7, 8, 9, 10 };
		SumSubSet s = new SumSubSet(A, 10);
		List<ArrayList<Integer>> results = s.sumSubSetRecursion();
		
		SumSubSet.printAllSolution(results);
		Assert.assertEquals(8, results.size());
		
		// Element has to be sorted 
		int[] B = { 1,4,5,8,9};
		SumSubSet s1 = new SumSubSet(B, 9);
		List<ArrayList<Integer>> results1 = s1.sumSubSetRecursion();
		
		SumSubSet.printAllSolution(results1);
		Assert.assertEquals(3, results1.size());
	}
}
