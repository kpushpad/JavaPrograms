package com.kpushpad.java.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoxTest {

	public static void main(String[] args) {
		Box a = new Box("box1", 3, 7, 8);
		Box b = new Box("box2", 4, 5, 6);
		Box c = new Box("box3", 5, 1, 2);

		List<Box> list = new ArrayList<>();

		list.add(a);
		list.add(b);
		list.add(c);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName());
		}
		System.out.println(" ");
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName());
		}
		System.out.println(" ");
		Collections.sort(list, Box.SortBoxByLength);
		

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName());
		}
	}

}
