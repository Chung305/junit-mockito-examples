package com.dev.unittesting.unittesting.business;

import com.dev.unittesting.unittesting.data.ItemRepository;
import com.dev.unittesting.unittesting.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ItemBusinessService {

    @Autowired
    private ItemRepository repository;

    public Item retrieveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }

    public List<Item> retrieveAllItems(){
        List<Item> allItems = repository.findAll();
        allItems.forEach(each -> each.setValue(each.getPrice() * each.getQuantity()));

        return allItems;


    }
}
