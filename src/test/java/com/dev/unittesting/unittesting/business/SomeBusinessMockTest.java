package com.dev.unittesting.unittesting.business;

import com.dev.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

    @InjectMocks
    SomeBusinessImplementation business = new SomeBusinessImplementation();
    @Mock
    SomeDataService data;

    @Test
    public void calculateSumUsingDataServiceBasic(){
        when(data.retrieveAllData()).thenReturn(new int[] {1,2,3});
        assertEquals(6, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_empty(){
        when(data.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_scenario(){
        when(data.retrieveAllData()).thenReturn(new int[] {5,5});
        assertEquals(10, business.calculateSumUsingDataService());
    }
}
