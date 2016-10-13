package com.example.didier.unittests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by didier on 6/17/16.
 */
public class Algo {

	private static List<Long> cache = new ArrayList<>();

	public static long getFibonacci(int index){
		if(index <= 1){
			return index;
		}

		return getFibonacci(index - 1) + getFibonacci(index - 2);
	}

	public static long getFibonacci2(int index){
		if(index == 0){ return 0; }
		if(index > 0 && index < 3){ return 1; }

		long result = 0;
		long prevResult = 1;
		long prevPrevResult = 1;

		for(int i=2; i<index; i++){
			result = prevResult + prevPrevResult;
			prevPrevResult = prevResult;
			prevResult = result;
		}

		return result;
	}

	public static long getFibonacci3(int index){
		if(index < cache.size()){
			return cache.get(index);
		}

		long fibValue;
		if(index <= 1){
			fibValue = index;
		}else{
			fibValue = getFibonacci3(index - 1) + getFibonacci3(index - 2);
		}

		cache.add(fibValue);
		return fibValue;
	}
}
