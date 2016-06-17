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

	public static int getFibonacci2(int index){
		if(index == 0){ return 0; }
		if(index > 0 && index < 3){ return 1; }

		int result = 0;
		int prevResult = 1;
		int prevPrevResult = 1;

		for(int i=2; i<index; i++){
			result = prevResult + prevPrevResult;
			prevPrevResult = prevResult;
			prevResult = result;
		}

		return result;
	}
}
