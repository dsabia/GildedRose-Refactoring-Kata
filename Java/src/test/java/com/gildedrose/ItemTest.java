package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ItemTest {

    @Test
    void toString_for_default_item() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        Item firstItem = items[0];

        assertEquals("foo, 0, 0", firstItem.toString());
    }

    @Test
    void toString_for_conjured_item() {
        Item[] items = new Item[] { new Item("Conjured foo", 0, 0) };
        Item firstItem = items[0];

        assertEquals("Conjured foo, 0, 0, conjured", firstItem.toString());
    }
}
