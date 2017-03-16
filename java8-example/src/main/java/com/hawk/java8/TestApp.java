package com.hawk.java8;

import java.util.ArrayList;
import java.util.List;

public class TestApp {
	
	public static void main(String[] args){
		System.out.println("");
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		
		System.out.println(list.get(list.size()));
		
//		System.out.println(list.get(list.size()-10));
		
		int[] i = new int[]{1,2,3};
		
		System.out.println(i[i.length]);
	}

}
