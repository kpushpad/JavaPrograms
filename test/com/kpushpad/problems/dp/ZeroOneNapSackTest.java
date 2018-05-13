package com.kpushpad.problems.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class ZeroOneNapSackTest {

	@Test
	public void testA() {
		int p[] = { 60, 100, 120 };
		int w[] = { 10, 20, 30 };
		int capacity = 50;

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(3);
		for (int i = 0; i < 3; i++) {
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.add(w[i]);
			l.add(p[i]);
			list.add(l);
		}

		ZeroOneNapSack obj = new ZeroOneNapSack(list, capacity);
		Assert.assertEquals(220, obj.calculateMaximumProfit());

		Set<Integer> s = new HashSet<Integer>();
		s.add(1);
		s.add(2);

		Assert.assertEquals(s, new HashSet<Integer>(obj.getAllItemsInKnapSack()));
	}

	@Test
	public void testB() {
		int p[] = { 18, 15, 10 };
		int w[] = { 25, 24, 15 };
		int capacity = 20;

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(3);
		for (int i = 0; i < 3; i++) {
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.add(w[i]);
			l.add(p[i]);
			list.add(l);
		}

		ZeroOneNapSack obj = new ZeroOneNapSack(list, capacity);
		Assert.assertEquals(10, obj.calculateMaximumProfit());

		Set<Integer> s = new HashSet<Integer>();
		s.add(2);

		Assert.assertEquals(s, new HashSet<Integer>(obj.getAllItemsInKnapSack()));
	}

	@Test
	public void testC() {
		int p[] = { 1,4,5,7 };
		int w[] = { 1,3,4,5 };
		int capacity = 7;

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(3);
		for (int i = 0; i < 3; i++) {
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.add(w[i]);
			l.add(p[i]);
			list.add(l);
		}

		ZeroOneNapSack obj = new ZeroOneNapSack(list, capacity);
		Assert.assertEquals(9, obj.calculateMaximumProfit());

		Set<Integer> s = new HashSet<Integer>();
		s.add(1);
		s.add(2);

		Assert.assertEquals(s, new HashSet<Integer>(obj.getAllItemsInKnapSack()));
	}
}
