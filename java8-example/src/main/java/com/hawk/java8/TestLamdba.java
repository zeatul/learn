package com.hawk.java8;

import java.util.Arrays;
/**
 * java8 新特性
 * lambda表达式
 * @author zhp
 *
 */
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
		
		int a = 10;
		int b = 11;
		testFunction(a,b, (e1,e2)->{System.out.println(e1+e2);});
	}
	
	

	/**
	 * @FunctionalInterface 注解的函数只允许有一个没有实现的方法，可以有多个默认的实现方法
	 * @author zhp
	 *
	 * @param <T>
	 */
	@FunctionalInterface
	public static interface Functional<T>{
		void method(T e1,T e2);
		
		default double sqrt(int a){
			return Math.sqrt(a);
		}
	}
	
	public static <T> void testFunction(T a1,T a2,Functional<T> fun){
		fun.method(a1,a2);
	}

}
