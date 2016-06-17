package com.example.didier.unittests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by didier on 6/15/16.
 */
@RunWith(Parameterized.class)
public class TestableTest {
    private int[] values;
    private int expected;

    public TestableTest(int[] values, int expected){
        this.values = values;
        this.expected = expected;
    }

    @Test
    public void doATest(){
        ITestable testable = new Testable();
        assertTrue(testable.doA());
    }

    @Test(expected = NullPointerException.class)
    public void doB_NullTest(){
        ITestable testable = new Testable();
        testable.doB(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void doB_EmptyTest(){
        ITestable testable = new Testable();
        List<Integer> list = new ArrayList<>();
        testable.doB(list);
    }

    @Test
    public void doBTest(){
        ITestable testable = new Testable();
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        assertEquals(testable.doB(list), 5, 0);
    }

    @Parameters
    public static List<Object[]> params(){
        return Arrays.asList(new Object[][]{
                {new int[]{5, 5}, 10},
                {new int[]{15, 5}, 20},
                {new int[]{65, 2}, 67}
        });
    }

    @Test
    public void dummyTest(){
        int sum = 0;
        for(int i=0; i<this.values.length; i++){
            sum += this.values[i];
        }
        assertEquals(sum, this.expected);
    }
}
