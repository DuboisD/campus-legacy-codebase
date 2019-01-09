package com.gildedrose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    Logger logger = LoggerFactory.getLogger(GildedRose.class);

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {

            if (!items[i].name.startsWith("Sulfuras")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn >= 0) {
                if (items[i].quality >= 0) {
                    if (!items[i].name.equals("Aged Brie") && !items[i].name.startsWith("Backstage passes")) {
                        if (items[i].quality > 0) {
                            items[i].quality = items[i].quality - 1;
                            if (items[i].name.startsWith("Conjured")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                            if (items[i].name.startsWith("Backstage passes")) {
                                if (items[i].sellIn < 11) {
                                    if (items[i].quality < 50) {
                                        items[i].quality = items[i].quality + 1;
                                    }
                                }
                                if (items[i].sellIn < 6) {
                                    if (items[i].quality < 50) {
                                        items[i].quality = items[i].quality + 1;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    items[i].quality = items[i].quality - items[i].quality;
                }


            } else {
                if (items[i].quality > 0) {
                    if (!items[i].name.startsWith("Sulfuras")
                            && !items[i].name.equals("Aged Brie")
                            && !items[i].name.startsWith("Backstage passes")) {
                            items[i].quality = items[i].quality - 1;
                    } else if (items[i].name.equals("Aged Brie")) {
                        items[i].quality = items[i].quality + 1;
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                }
            }

            logger.info("name is {}, sellIn is {} and quality is {}", items[i].name, items[i].sellIn, items[i].quality);

        }

    }

    public Item[] getItems() {
        return items;
    }
}