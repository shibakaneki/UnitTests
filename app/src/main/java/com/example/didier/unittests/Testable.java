package com.example.didier.unittests;

import java.util.List;

/**
 * Created by didier on 6/15/16.
 */
public class Testable implements ITestable {
    @Override
    public boolean doA() {
        return true;
    }

    @Override
    public float doB(List<Integer> list) {
        if(null == list){
            throw new NullPointerException("list");
        }

        if(list.isEmpty()){
            throw new IllegalArgumentException("list");
        }

        int sum = 0;
        for(Integer i : list){
            sum += i;
        }

        float avg = (float)sum / (float)list.size();
        return avg;
    }
}
