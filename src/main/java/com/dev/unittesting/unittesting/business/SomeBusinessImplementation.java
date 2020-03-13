package com.dev.unittesting.unittesting.business;

import com.dev.unittesting.unittesting.data.SomeDataService;

import java.util.Arrays;

public class SomeBusinessImplementation {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data){
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    public int calculateSumUsingDataService(){
        return Arrays.stream(someDataService.retrieveAllData()).reduce(Integer::sum).orElse(0);
    }


}
