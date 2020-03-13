package com.dev.unittesting.unittesting.business;

import com.dev.unittesting.unittesting.data.ItemRepository;
import com.dev.unittesting.unittesting.models.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BusinessServiceTest {

    @InjectMocks
    private ItemBusinessService itemBusinessService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void retrieveAllData_Basic(){
        when(itemRepository.findAll())
                .thenReturn(Arrays.asList(
                new Item(2, "item1", 10, 50),
                new Item(3,"item2", 12, 30)));

        List<Item> items = itemBusinessService.retrieveAllItems();

        assertEquals(500, items.get(0).getValue());
        assertEquals(360, items.get(1).getValue());

    }


}
