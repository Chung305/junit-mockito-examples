package com.dev.unittesting.unittesting.controller;

import com.dev.unittesting.unittesting.business.ItemBusinessService;
import com.dev.unittesting.unittesting.models.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//run springRunner for spring tests
//webmvc to test controller responses
@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    public void item_basic() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"Ball\",\"price\":10,\"quantity\":100,\"id\":1}"))
                .andReturn();
        //JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false); ==> spike package
    }

    @Test
    public void itemFromBusinessService_basic() throws Exception{

        when(businessService.retrieveHardcodedItem())
                .thenReturn(new Item(2, "item2", 2, 6));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"item2\",\"price\":2,\"quantity\":6,\"id\":2}"))
                .andReturn();
        //JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false); ==> spike package
    }

    @Test
    public void retrieveAllItems_basic() throws Exception{

        when(businessService.retrieveAllItems())
                .thenReturn(Arrays.asList(
                        new Item(2, "item1", 10, 50),
                        new Item(3,"item2", 12, 30)));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:2, name:item1, price:10},{id:3, name:item2, price:12}]"))
                .andReturn();
        //JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false); ==> spike package
    }
}
