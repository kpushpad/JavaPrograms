package com.kpushpad.java.sort;

import java.util.Comparator;

public class Box implements Comparable<Box> {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHight() {
		return hight;
	}

	public void setHight(double hight) {
		this.hight = hight;
	}
	
	private String name;
	private double length;
	private double width;
	private double hight;
	
	Box(String name, double length, double width, double hight) {
		this.name = name;
		this.length = length;
		this.width = width;
		this.hight = hight;	
	}
	
	private double getVolume() {
		return length*width*hight;
	}

	
	public static final Comparator<Box> SortBoxByLength = new Comparator<Box>() {
		@Override
		public int compare(Box o1, Box o2) {
			return (int)(o1.getLength() - o2.getLength());
		}
	};

	public static final Comparator<Box> SortBoxByLength1 = (o1, o2) -> {
		return (int)(o1.getLength() - o2.getLength());
	};
	
	@Override
	public int compareTo(Box o) {
	        
		return (int)(this.getVolume() - o.getVolume());
	}

}
