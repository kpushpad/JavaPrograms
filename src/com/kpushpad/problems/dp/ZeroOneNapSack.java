package com.kpushpad.problems.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Kamal Kumar Pushpad
 */

public class ZeroOneNapSack {
	private List<ArrayList<Integer>> items;
	private int capacity;
	private int maxProfit;

	public int getMaxProfit() {
		return maxProfit;
	}

	ZeroOneNapSack(List<ArrayList<Integer>> items, int capacity) {
		this.items = items;
		this.capacity = capacity;
		this.maxProfit = 0;
	}

	public int calculateMaximumProfit() {
		int[][] matrix = new int[items.size() + 1][capacity + 1];
		init(matrix);

		for (int i = 1, k = 0; i <= items.size(); i++, k++) {
			for (int j = 1; j <= capacity; j++) {

				if (j >= items.get(k).get(0)) {
					matrix[i][j] = Math.max(matrix[i - 1][j],
							items.get(k).get(1) + matrix[i - 1][j - items.get(k).get(0)]);
				} else {
					matrix[i][j] = matrix[i - 1][j];
				}
			}
		}
		return matrix[items.size()][capacity];
	}

	public ArrayList<Integer> getAllItemsInKnapSack() {
		int[][] matrix = new int[items.size() + 1][capacity + 1];
		init(matrix);
		
		Map<Integer,ArrayList<Integer>> itemList = new HashMap<Integer, ArrayList<Integer>>();
		itemList.put(0, new ArrayList<Integer>());

		for (int i = 1, k = 0; i <= items.size(); i++, k++) {
			
			ArrayList<Integer> list=null;
			for (int j = 1; j <= capacity; j++) {

				
				if (!itemList.containsKey(j)) {
					list = new ArrayList<Integer>();
					itemList.put(j, list);
				}
				
				if (j >= items.get(k).get(0)) {
					int p1 = matrix[i - 1][j];
					int p2 = items.get(k).get(1) + matrix[i - 1][j - items.get(k).get(0)];
					
					matrix[i][j] = Math.max(p1, p2);
					// Record which item is getting picked up
					
					
					if (p1 < p2) {
						ArrayList<Integer> l = new ArrayList<Integer>();
						l.add(k); 
						l.addAll(itemList.get(j - items.get(k).get(0)));
						// Delete old list and put new list
						itemList.get(j).clear();
						itemList.get(j).addAll(l);
					} 
					
				} else {
					matrix[i][j] = matrix[i - 1][j];
				}
			}
		}
		return itemList.get(capacity); // Last list will be our result 
	}
	private void init(int[][] matrix) {
		for (int i = 0; i < items.size(); i++) {
			matrix[i][0] = 0;
		}

		for (int j = 0; j < capacity; j++) {
			matrix[0][j] = 0;
		}
	}
}
