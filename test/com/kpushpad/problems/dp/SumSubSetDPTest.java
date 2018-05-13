package com.kpushpad.problems.dp;

import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SumSubSetDPTest {

	@Test
	public void testA() {
		int[] A = { 4, 5, 9, 8, 1 };
		SumSubSetDP s = new SumSubSetDP(A, 9);
		Assert.assertEquals(true, s.isSumSubSetExist());
		
		List<HashSet<Integer>> ss = s.getAllSumSubSet();
		Assert.assertEquals(3, ss.size());
	}

	@Test
	public void testB() {
		int[] A = { 1, 2, 3, 4, 10, 6, 7, 8, 9 };
		SumSubSetDP s = new SumSubSetDP(A, 10);
		Assert.assertEquals(true, s.isSumSubSetExist());
		
		List<HashSet<Integer>> ss = s.getAllSumSubSet();
		System.out.println(ss);
		Assert.assertEquals(8, ss.size());
	}

	@Test
	public void testC() {
		int[] A = { 1, 2, 3, 4, 10, 6, 7, 8, 9 };
		SumSubSetDP s = new SumSubSetDP(A, 100);
		Assert.assertEquals(false, s.isSumSubSetExist());
		
		List<HashSet<Integer>> ss = s.getAllSumSubSet();
		Assert.assertEquals(0, ss.size());
	}
	
	@Test
	public void testD() {
		int[] A = { 1, 2};
		SumSubSetDP s = new SumSubSetDP(A, 10);
		Assert.assertEquals(false, s.isSumSubSetExist());
		
		List<HashSet<Integer>> ss = s.getAllSumSubSet();
		Assert.assertEquals(0, ss.size());
	}
}
