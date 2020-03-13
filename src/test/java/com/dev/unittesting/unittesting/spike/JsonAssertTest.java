package com.dev.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String str = "{\"name\":\"Ball\",\"price\":10,\"quantity\":100,\"id\":1}";

    @Test
    public void jsonAssertStrict() throws JSONException {
        String expectedResponse = "{\"name\":\"Ball\",\"price\":10,\"quantity\":100,\"id\":1}";
        JSONAssert.assertEquals(expectedResponse, str, true);
    }

    @Test
    public void jsonAssertStrictFalse() throws JSONException {
        String expectedResponse = "{\"name\":\"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expectedResponse, str, false);
    }

    @Test
    public void jsonAssertWithoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{name:Ball, price:10, quantity:100, id:1}";
        JSONAssert.assertEquals(expectedResponse, str, false);
    }
}
