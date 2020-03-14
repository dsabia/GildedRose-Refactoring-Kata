package com.gildedrose;

import java.util.stream.Stream;

class GildedRose {

    static final String AGED_BRIE = "Aged Brie";
    static final String BACKSTAGE_PASSES_TO_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item currentItem : items) {
            final String name = currentItem.getName();

            if (Stream.of(AGED_BRIE, BACKSTAGE_PASSES_TO_TAFKAL80ETC_CONCERT, SULFURAS_HAND_OF_RAGNAROS).noneMatch(items -> items.equals(name))) {
                currentItem.decrementQuality();
            } else {
                currentItem.incrementQuality();
                if (BACKSTAGE_PASSES_TO_TAFKAL80ETC_CONCERT.equals(name)) {
                    if (currentItem.getSellIn() < 6) {
                        currentItem.incrementQuality();
                        currentItem.incrementQuality();
                    } else if (currentItem.getSellIn() < 11) {
                        currentItem.incrementQuality();
                    }
                }
            }

            if (!SULFURAS_HAND_OF_RAGNAROS.equals(name)) {
                currentItem.decrementSellIn();
            }

            if (currentItem.getSellIn() < 0) {
                if (AGED_BRIE.equals(name)) {
                    currentItem.incrementQuality();
                } else if (BACKSTAGE_PASSES_TO_TAFKAL80ETC_CONCERT.equals(name)) {
                    currentItem.setQualityToBottomLimit();
                } else if (!SULFURAS_HAND_OF_RAGNAROS.equals(name)) {
                    currentItem.decrementQuality();
                }
            }
        }
    }
}