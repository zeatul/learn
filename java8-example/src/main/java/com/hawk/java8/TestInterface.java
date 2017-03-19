package com.hawk.java8;

/**
 * java8 新特性
 * 接口默认方法
 * @author zhp
 *
 */
public class TestInterface {
	
	public static interface Formula{
		double calculate(int a);
		default double sqrt(int a) {
			return Math.sqrt(a);
		}
	}
	
	public static void main(String args[]){
		
		Formula formula = new Formula(){

			@Override
			public double calculate(int a) {
				return sqrt(a);
			}
			
		};
		
		System.out.println(formula.calculate(25));
	}

}
