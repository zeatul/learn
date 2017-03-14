package com.hawk.java8;

import java.util.Arrays;

public class TestLamdba {

	public static void main(String[] args) {
		Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));

		Arrays.asList("a", "b", "c").forEach((String e) -> System.out.println(e));

		String seperator = ",";
		Arrays.asList("a", "b", "c").forEach((String e) -> {
			System.out.print(e + seperator);
		});

		Arrays.asList("a", "b", "c").sort((e1, e2) -> e1.compareTo(e2));

		Arrays.asList("a", "b", "c").sort((e1, e2) -> {
			int result = e1.compareTo(e2);
			return result;
		});
		
		testFunction(System.out.println());
	}
	
	private static void testFunction(Object println) {
		// TODO Auto-generated method stub
		
	}

	@FunctionalInterface
	public static interface Functional{
		void method();
	}
	
	public static void testFunction(Functional fun){
		fun.method();
	}

}
