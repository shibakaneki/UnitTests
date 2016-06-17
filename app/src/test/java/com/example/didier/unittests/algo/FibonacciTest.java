package com.example.didier.unittests.algo;

import com.example.didier.unittests.Algo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by didier on 6/17/16.
 */
@RunWith(Parameterized.class)
public class FibonacciTest {

	private int index;
	private int expected;

	public FibonacciTest(int index, int expected){
		this.index = index;
		this.expected = expected;
	}

	@Parameters
	public static List<Object[]> params(){
		return Arrays.asList(new Object[][]{
				{0, 0},
				{1, 1},
				{2, 1},
				{3, 2},
				{4, 3},
				{5, 5},
				{6, 8},
				{7, 13},
				{8, 21},
				{9, 34},
				{10, 55},
				{11, 89},
				{12, 144},
				{13, 233},
				{14, 377},
				{15, 610},
				{16, 987},
				{17, 1597},
				{18, 2584},
				{19, 4181},
				{20, 6765}
		});
	}

	@Test
	public void getFibonacciTest(){
		assertEquals(this.expected, Algo.getFibonacci(this.index));
	}
}
