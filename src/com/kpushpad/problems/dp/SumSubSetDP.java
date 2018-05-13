package com.kpushpad.problems.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/**
 * @author Kamal Kumar Pushpad
 *   O(sum * numbers)
 */
public class SumSubSetDP {

	private int sum;
	private int[] numbers;
	

	SumSubSetDP(int nums[], int sum) {
		this.numbers = nums;
		this.sum = sum;
	}

	public boolean isSumSubSetExist() {
		boolean[][] matrix = new boolean[numbers.length + 1][sum + 1];
		init(matrix);

		for (int i = 1, k = 0; i <= numbers.length; i++, k++) {
			for (int j = 1; j <= sum; j++) {

				if (j >= numbers[k]) {
					matrix[i][j] = matrix[i - 1][j - numbers[k]] ? true : false;
				} else {
					matrix[i][j] = matrix[i - 1][j];
				}
			}
		}
		return matrix[numbers.length][sum];
	}

	/**
	 * Let say sum is 5 then
	 * 
	 * Map<Integer,ArrayList<HashSet<Integer>>> valSet = new HashMap<Integer,
	 * ArrayList<HashSet<Integer>>>();
	 * 
	 * 0 -> [ {} ] 
	 * 1 -> [ {1} ]
	 * 2 -> [ {2} ] 
	 * 3 -> [ {3}  {1,2} ] 
	 * 4 -> [ {4} , {3,1}
	 * 5 -> [ {5} , {4,1} , {3,1,1}]
	 * 
	 * To get for value of key j , either j if sum==j and for all sets in valSet.get(j- numbers[k]) mix j
	 * with them and create new sets
	 */
	public List<HashSet<Integer>> getAllSumSubSet() {
		boolean[][] matrix = new boolean[numbers.length + 1][sum + 1];
		init(matrix);

		Map<Integer, ArrayList<HashSet<Integer>>> valSet = new HashMap<Integer, ArrayList<HashSet<Integer>>>();
		// Create empty set for key 0
		HashSet<Integer> emptySet = new HashSet<Integer>();
		ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
		list.add(emptySet);
		valSet.put(0, list);

		for (int i = 1, k = 0; i <= numbers.length; i++, k++) {
			ArrayList<HashSet<Integer>> setList;
			for (int j = 1; j <= sum; j++) {
				if (j >= numbers[k]) {
                     
					// Don't create list if it already exist ,add new sets to old list 
					// There will be only one list for each sum 
					
					if (valSet.containsKey(j)) {
						setList = valSet.get(j);
					} else {
						setList = new ArrayList<HashSet<Integer>>();
					}
					// Record number[k] as we can make j using numbers[k]
					if (j == numbers[k]) {
						HashSet<Integer> s1 = new HashSet<Integer>();
						s1.add(numbers[k]);
						setList.add(s1);
					}
					matrix[i][j] = matrix[i - 1][j - numbers[k]] ? true : false;

					// Record all sets whose elements sums upto j , we will find our result when j  == sum
					if (matrix[i][j]) {
						// Mix j with all sets present at (j - numbers[k]) key to get all possible combination which sums upto j
						// if j=6 and number[k]=3   then(j - numbers[k]) is  3 -> [ {1,2} , {3} ]
						 
						for (HashSet<Integer> s : valSet.get(j - numbers[k])) {
							if (!s.isEmpty()) {
								HashSet<Integer> s2 = new HashSet<Integer>();
                                
                                 // Check for duplicate element in result set as set with duplicate can't be our solution
								if (!s.contains(numbers[k])) {
									s2.add(numbers[k]);
									s2.addAll(s);
									setList.add(s2);
								}								
							}
						}
						valSet.put(j, setList);
					}
				} else {
					matrix[i][j] = matrix[i - 1][j];

					// If list doesn't exist for j then create it first time with empty set
					if (!valSet.containsKey(j)) {
						// Create empty set for key j
						HashSet<Integer> s3 = new HashSet<Integer>();
						setList = new ArrayList<HashSet<Integer>>();
						setList.add(s3);
						valSet.put(j, setList);
					}
				}
			}
		}
		return valSet.get(sum);
	}

	private void init(boolean[][] matrix) {
		for (int i = 0; i <= numbers.length; i++) {
			matrix[i][0] = true;
		}

		for (int j = 0; j <= sum; j++) {
			matrix[0][j] = false;
		}
		matrix[0][0] = true;
	}
}
