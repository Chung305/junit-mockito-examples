package com.dev.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessTest {

    @Test
    public void calculateSumBasic(){
        SomeBusinessImplementation business = new SomeBusinessImplementation();
        int actual  = business.calculateSum(new int[] { 1,2,3});
        int expect = 6;

        assertEquals(expect, actual);
    }

    @Test
    public void calculateSumBasic_empty(){
        SomeBusinessImplementation business = new SomeBusinessImplementation();
        int actual  = business.calculateSum(new int[] { });
        int expect = 0;

        assertEquals(expect, actual);
    }

    @Test
    public void calculateSumBasic_scenario(){
        SomeBusinessImplementation business = new SomeBusinessImplementation();
        int actual  = business.calculateSum(new int[] {5,5 });
        int expect = 10;

        assertEquals(expect, actual);
    }
}
