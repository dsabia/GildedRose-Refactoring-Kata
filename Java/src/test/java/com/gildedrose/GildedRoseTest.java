package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class GildedRoseTest {

    @Test
    void foo_is_an_acceptable_name() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item firstItem = app.items[0];
        assertEquals("foo", firstItem.getName());
        assertEquals(-1, firstItem.getSellIn());
        assertEquals(0, firstItem.getQuality());
    }

    @ParameterizedTest
    @CsvSource({"0,-1", "1,0", "-1,-2"})
    void sell_in_decrement_any_iteration(Integer sellIn, Integer expectedSellIn) {
        Item[] items = new Item[] { new Item("foo", sellIn, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item firstItem = app.items[0];
        assertEquals(expectedSellIn, firstItem.getSellIn());
    }

    @ParameterizedTest
    @CsvSource({"0,0", "1,0", "-1,-1"})
    void quality_set_to_zero_or_negative_with_sellIn_zero(Integer quality, Integer expectedQuality) {
        Item[] items = new Item[] { new Item("foo", 0, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item firstItem = app.items[0];
        assertEquals(expectedQuality, firstItem.getQuality());
    }


    @ParameterizedTest
    @CsvSource({"0,0,-1,2", "2,0,1,1"})
    void case_Aged_Brie(Integer sellIn, Integer quality, Integer expectedSellIn, Integer expectedQuality) {
        Item[] items = new Item[] { new Item("Aged Brie", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item firstItem = app.items[0];
        assertEquals("Aged Brie", firstItem.getName());
        assertEquals(expectedSellIn, firstItem.getSellIn());
        assertEquals(expectedQuality, firstItem.getQuality());
    }

    @ParameterizedTest
    @CsvSource({"0,80,0,80", "20,80,20,80", "-20,80,-20,80"})
    void case_Sulfuras_Hand_of_Ragnaros(Integer sellIn, Integer quality, Integer expectedSellIn, Integer expectedQuality) {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item firstItem = app.items[0];
        assertEquals("Sulfuras, Hand of Ragnaros", firstItem.getName());
        assertEquals(expectedSellIn, firstItem.getSellIn());
        assertEquals(expectedQuality, firstItem.getQuality());
    }

    @ParameterizedTest
    @CsvSource({"15,20,14,21", "10,20,9,22", "5,20,4,23", "-5,20,-6,0"})
    void case_Backstage_Passes_to_a_TAFKAL80ETC_Concert(Integer sellIn, Integer quality, Integer expectedSellIn, Integer expectedQuality) {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item firstItem = app.items[0];
        assertEquals("Backstage passes to a TAFKAL80ETC concert", firstItem.getName());
        assertEquals(expectedSellIn, firstItem.getSellIn());
        assertEquals(expectedQuality, firstItem.getQuality());
    }

    @ParameterizedTest
    @CsvSource({"3,6,2,5"})
    void case_Conjured_Mana_Cake(Integer sellIn, Integer quality, Integer expectedSellIn, Integer expectedQuality) {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item firstItem = app.items[0];
        assertEquals("Conjured Mana Cake", firstItem.getName());
        assertEquals(expectedSellIn, firstItem.getSellIn());
        assertEquals(expectedQuality, firstItem.getQuality());
        assertTrue(firstItem.isConjured());
    }
}
