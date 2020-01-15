package com.adhoc.java.functional.labs.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LambdasLab {
	
	List<Integer> filterNumbers(int[] array, IntPredicate e) {
		List<Integer> result = new ArrayList<>();
		for(int val:array) {
			if(e.test(val)) {
				result.add(val);
			}
		}
		return result;
	}
	

	@Test
	void filterOddNumbersTest() {
		List<Integer> result = filterNumbers(new int[]{1,1,2,3,5,8,13,21}, t -> t%2==1);
		Assertions.assertEquals(6, result.size());
	}
	
	//TODO: rewrite filterOddNumbers to apply Strategy and accept a lambda
	//TODO: rewrite filterOddNumbersTest to use the lambda version of filterOddNumbers
	//TODO: rename filterOddNumbers to generalize its functionality, name it "filterNumbers"
	
	//TODO: complete this test to filter even numbers
	@Test
	void filterEvenNumbersTest() {
		
		List<Integer> result = filterNumbers(new int[]{1,1,2,3,5,8,13,21}, t -> t%2==0);
		
		Assertions.assertEquals(2, result.size());
	}

}
