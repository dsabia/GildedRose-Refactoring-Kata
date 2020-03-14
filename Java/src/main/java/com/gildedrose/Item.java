package com.gildedrose;

import java.util.Optional;

public class Item {
    private static final String CONJURED_ITEM = "CONJURED";

    private static final int QUALITY_TOP_LIMIT = 50;
    private static final int QUALITY_BOTTOM_LIMIT = 0;

    private String name;
    private Integer sellIn;
    private Integer quality;
    private Boolean conjured;

    public Item(String name, Integer sellIn, Integer quality) {
        Optional.ofNullable(name).ifPresent(inputName -> {
            this.name = inputName;
            this.conjured = inputName.toUpperCase().contains(CONJURED_ITEM);
        });
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName() {
        return this.name;
    }

    public Integer getQuality() {
        return quality;
    }

    public Integer getSellIn() {
        return sellIn;
    }

    public boolean isConjured() {
        return this.conjured;
    }

    public void incrementQuality() {
        if (quality < QUALITY_TOP_LIMIT) {
            this.quality++;
        }
    }

    public void decrementQuality() {
        if (quality > QUALITY_BOTTOM_LIMIT) {
            this.quality--;
        }
    }

    public void decrementSellIn() {
        this.sellIn--;
    }

    public void setQualityToBottomLimit() {
        this.quality = QUALITY_BOTTOM_LIMIT;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality + (this.conjured ? ", conjured" : "");
    }
}
