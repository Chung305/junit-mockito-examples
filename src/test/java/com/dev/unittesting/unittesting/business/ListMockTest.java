package com.dev.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);
    @Test
    public void size_basic(){
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void return_different_values(){
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void return_with_parameters(){
        when(mock.get(0)).thenReturn("learning");
        assertEquals("learning", mock.get(0));
        assertNull(mock.get(1));
    }

    @Test
    public void return_with_generic_parameter(){
        when(mock.get(anyInt())).thenReturn("learning");
        assertEquals("learning", mock.get(0));
        assertEquals("learning", mock.get(2));
    }

    @Test
    public void verificationBasics(){
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void captureArgument(){
        mock.add("someString");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("someString", captor.getValue());
    }

    @Test
    public void multipleCaptureArgument(){
        mock.add("someString1");
        mock.add("someString2");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());
        List<String> allValues = captor.getAllValues();

        assertEquals("someString1", allValues.get(0));
        assertEquals("someString2", allValues.get(1));

    }

    @Test
    public void mocking(){
        ArrayList arrayListMock = mock(ArrayList.class);
        //mock just mocks class and behavior controlled by you

        arrayListMock.get(0);
        arrayListMock.add(123);
        arrayListMock.add(234234);

        when(arrayListMock.size()).thenReturn(5);
    }

    @Test
    public void spying(){
        ArrayList arrayListSpy = spy(ArrayList.class);
        //spying uses actual class behavior
    }
}
