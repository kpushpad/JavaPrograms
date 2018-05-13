package com.kpushpad.problems.backtraking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/***
 * 
 * @author kpushpad (Kamal Pushpad)
 *
 */

public class SumSubSet {
	
	private int sum;
	private int []numbers;
	private List<ArrayList<Integer>> results;
	private HashMap<Integer,Integer> lookupTable;
	
	/** 
	 *  Elements in array has to be sorted and no duplicates 
	 */
	SumSubSet(int nums[], int sum) {
		this.numbers = nums;
		this.sum = sum;
		this.results = new ArrayList<ArrayList<Integer>>();
		lookupTable = new HashMap<Integer,Integer>();
	}
	
	
	public  List<ArrayList<Integer>> sumSubSetRecursion() {
		buildReverseLookupTable();
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		findSumSubSet(numbers, 0, 0, result);
		return results;
	}
	
	private void findSumSubSet(int[] a, int i, int countingSum, ArrayList<Integer> result) {
		if (i == a.length) {
			return;
		}

		if (countingSum + a[i] < sum) {
			result.add(a[i]);
			countingSum += a[i];
			findSumSubSet(a, i + 1, countingSum, result);
		} else if (countingSum + a[i] == sum) {
			result.add(a[i]);
			results.add(result);
			//copy current set as we found one solution
			ArrayList<Integer> newResult = new ArrayList<Integer>();
			newResult.addAll(result);
			
			//Backtrack and try next element
			newResult.remove(newResult.size() -1);
			result = newResult;
			findSumSubSet(a, i+1, countingSum, result);
		} else {
		   /**BackTrack 
		    * Delete last value from candidate set and try next value from array 
		    * We don't known the index of val which is being deleted that's why we need to build lookup table
		    * Lookup table can be avoided if we  use ArrayList<HashMAp<Integer,Integer> result  instead of List<ArrayList<Integer>> results
		    *  to store our candidate set
		    *  Or we only need to remember indexes of current candidate set so no need to lookup table 
		    */
			//Backtrack and try next element after deleted one
           int val = result.remove(result.size() -1);
           findSumSubSet(a, (lookupTable.get(val) + 1) , countingSum- val, result);
		}
	}
	
	private void buildReverseLookupTable() {
		// Build Reverse lookup table
        for (int i = 0; i < numbers.length; i++) {
        	    lookupTable.put(numbers[i], i);
        }
	}

	public static List<ArrayList<Integer>> calAllSetForGivemSum(int A[], int sum) {
		List<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
       
        HashMap<Integer,Integer> lookupTable = new HashMap<Integer,Integer>();
        
        // Build Reverse lookup table
        for (int i = 0; i < A.length; i++) {
        	    lookupTable.put(A[i], i);
        }
        
		for (int i = 0; i < A.length; i++) {
			int countingSum = 0;
			ArrayList<Integer> result = new ArrayList<Integer>();

			for (int j = i; j < A.length; j++) {
				if (countingSum + A[j] < sum) {
					result.add(A[j]);
					countingSum += A[j];
				} else if (countingSum + A[j] == sum) {
					// Add one result set to list
					result.add(A[j]);
					results.add(result);
					//Backtrack by deleting last value and keep try from next value 
					if (result.size() > 1) {
                       //copy all elements except last one , means we are backtracking and try next elem
						ArrayList<Integer> newResult = new ArrayList<Integer>();
						newResult.addAll(result);
						newResult.remove(newResult.size() -1);
						result = newResult;
					} else {
						//if only one element in set then outer loop will take care of choosing next 
						break;
					}				
				} else {
					//Backtrack only if more than 1 element is there bcoz for one element outer loop will take care of advancing 
					if ((j == A.length -1) && result.size() > 1) {
						// Delete one element a d try next 
						int val = result.remove(result.size() -1);	
						countingSum -= val;
						j = lookupTable.get(val);
					}		
				}
			} // Inner For Loop
		} // Outer For loop
		return results;
	}
	
	public static void printAllSolution(List<ArrayList<Integer>> results) {
		for (ArrayList<Integer> result : results) {
			System.out.println(result);
		}
	}
}
