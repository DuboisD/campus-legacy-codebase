package com.gildedrose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        Logger logger = LoggerFactory.getLogger(GildedRose.class);

        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {

                logger.info(items[i].name);

                if (items[i].quality > 0) {

                    logger.info("item[i].quality is above 0");

                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        if (!items[i].name.equals("Conjured Mana Cake")) {
                            items[i].quality = items[i].quality - 1;
                            logger.info("{} quality for all exept sulfuras", items[i].quality);

                        } else {
                            items[i].quality = items[i].quality - 2;
                            logger.info("{} quality for sulfuras", items[i].quality);
                        }
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                                logger.info("{} quality for backstage with sellIn < 11", items[i].quality);
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                                logger.info("{} quality for backstage with sellIn < 6", items[i].quality);
                            }
                        }
                    }
                } else {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        logger.debug("{} is above 50", items[i].quality);
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
                logger.info("{} quality for all exept sulfuras", items[i].sellIn);
            }

            if (items[i].sellIn < 0) {
                logger.info("sellIn is {}", items[i].sellIn);

                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                                logger.info("{} quality for all exept brie, Backstage and sulfuras when quality{} ", items[i].quality, items[i].sellIn);

                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                        logger.info("{} quality for Backstage and sulfuras when quality{} ", items[i].quality);
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                        logger.info("{} quality for brie when quality {} ", items[i].quality);
                    }
                }
            }
        }
    }

    public Item[] getItems() {
        return items;
    }
}