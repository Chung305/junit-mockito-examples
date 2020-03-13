package com.dev.unittesting.unittesting.business;

import com.dev.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {1,2,3};
    }
}
class SomeDataServiceStubEmpty implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {};
    }
}

class SomeDataServiceStubScenario implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {5,5};
    }
}
public class SomeBusinessStubTest {

    @Test
    public void calculateSumUsingDataServiceBasic(){
        SomeBusinessImplementation business = new SomeBusinessImplementation();
        business.setSomeDataService(new SomeDataServiceStub());
        int actual  = business.calculateSumUsingDataService();
        int expect = 6;

        assertEquals(expect, actual);
    }

    @Test
    public void calculateSumUsingDataService_empty(){
        SomeBusinessImplementation business = new SomeBusinessImplementation();
        business.setSomeDataService(new SomeDataServiceStubEmpty());
        int actual  = business.calculateSumUsingDataService();
        int expect = 0;

        assertEquals(expect, actual);
    }

    @Test
    public void calculateSumUsingDataService_scenario(){
        SomeBusinessImplementation business = new SomeBusinessImplementation();
        business.setSomeDataService(new SomeDataServiceStubScenario());
        int actual  = business.calculateSumUsingDataService();
        int expect = 10;

        assertEquals(expect, actual);
    }
}
