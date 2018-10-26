package com.demo.tests;

import static org.junit.Assert.*;

import org.junit.Test;

class SimpleClass {
	public int sum(int[] numbers) {
		int sum = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		
		return sum;
	}
}

public class FirstJUnitTests {

	@Test
	public void test() {
		//Execute the code
		SimpleClass simpleClass = new SimpleClass();
		int actualResult = simpleClass.sum(new int[] {12, 15, 18});
		
		System.out.println(actualResult);
		
		//Check the output
		int expectedResult = 45;
		//check expectedResult is equal to actualResult
		assertEquals(expectedResult, actualResult);
		
		//No checks
		//Checks
		//Absence of Failure is Success
	}

	@Test
	public void test_for_zero_elements() {
		//Execute the code
		SimpleClass simpleClass = new SimpleClass();
		int actualResult = simpleClass.sum(new int[] {});
		
		System.out.println(actualResult);
		
		//Check the output
		int expectedResult = 0;
		//check expectedResult is equal to actualResult
		assertEquals(expectedResult, actualResult);
		
		//No checks
		//Checks
		//Absence of Failure is Success
	}
	
	@Test
	public void test_for_two_elements() {
		//Execute the code
		SimpleClass simpleClass = new SimpleClass();
		int actualResult = simpleClass.sum(new int[] {12, 15});
		
		System.out.println(actualResult);
		
		//Check the output
		int expectedResult = 27;
		//check expectedResult is equal to actualResult
		assertEquals(expectedResult, actualResult);
		
		//No checks
		//Checks
		//Absence of Failure is Success
	}
	
	@Test
	public void test_for_five_elements() {
		//Execute the code
		SimpleClass simpleClass = new SimpleClass();
		int actualResult = simpleClass.sum(new int[] {2, 6, 8, 15, 18});
		
		System.out.println(actualResult);
		
		//Check the output
		int expectedResult = 49;
		//check expectedResult is equal to actualResult
		assertEquals(expectedResult, actualResult);
		
		//No checks
		//Checks
		//Absence of Failure is Success
	}
}
