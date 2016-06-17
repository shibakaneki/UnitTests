package com.example.didier.unittests;

/**
 * Created by didier on 6/17/16.
 */
public class Algo {

	public static int getFibonacci(int index){
		if(index <= 1){
			return index;
		}

		return getFibonacci(index - 1) + getFibonacci(index - 2);
	}

}
