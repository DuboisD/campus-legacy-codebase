package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GildedRose {
    Item[] items;
    public static final Logger logger = LoggerFactory.getLogger(GildedRose.class);

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * Doing the job.
     * foreach item will check if is legendary, cheesy, a pass or conjured
     * for item.category : update'Category'
     */
    public void updateQuality() {
        for (Item item : items) {
            logger.info("ITEM :: " + item.toString());
            chooseWhatToDo(item);
        }
    }

    /**
     * does what it say
     *
     * @param item
     */
    public void chooseWhatToDo(Item item) {
        if (item.isCheese()) updateCheese(item);
        else if (item.isAPass()) updatePass(item);
        else if (item.isConjured()) updateConjured(item);
        else if (item.isLegendary()) updateLegendary(item);
        else if (item.isWine()) updateWine(item);
        else updateOther(item);
    }

    /**
     * @param item
     */
    public void updateLegendary(Item item) {
        //do Nothing, this is legendary BRO !
    }

    /**
     * increment chesse once
     * if soldout, increment seconde time
     *
     * @param item
     */
    public void updateCheese(Item item) {
        decreaseSellIn(item);

        increaseQuality(item);
        if (item.isSoldOut()) increaseQuality(item);
    }

    /**
     * increment pass once
     * if sellin < 10 increment another timer
     * if sellin < 5 increment another timer
     * if sellin = 0, quality killes
     *
     * @param item
     */
    public void updatePass(Item item) {
        decreaseSellIn(item);

        increaseQuality(item);
        if (item.sellIn <= 10) increaseQuality(item);
        if (item.sellIn <= 5) increaseQuality(item);
        if (item.isSoldOut()) item.quality = 0;
    }

    /**
     * decrease conjured twice
     * if soldout decrease twice more
     *
     * @param item
     */
    public void updateConjured(Item item) {
        decreaseSellIn(item);

        decreaseQuality(item);
        decreaseQuality(item);
        if (item.isSoldOut()) {
            decreaseQuality(item);
            decreaseQuality(item);
        }
    }

    /**
     * decrement quality of normal item
     *
     * @param item
     */
    public void updateOther(Item item) {
        decreaseSellIn(item);

        decreaseQuality(item);
        if (item.isSoldOut()) decreaseQuality(item);
    }

    /**
     * decrease wine if sellIn < 0
     *
     * @param item
     */
    public void updateWine(Item item) {
        decreaseSellIn(item);

        if (item.isSoldOut() && item.isSoldOutC()) decreaseQuality(item);
        if (item.isSoldOut() && !item.isSoldOutC()) increaseQuality(item);
    }


    /**
     * item.sellIn decreament
     * does what it says
     *
     * @param item
     */
    public void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    /**
     * item.quality increment
     * <p>
     * if quality less or equal from 0, item is reset to 0 (just in case)
     * then icrement the quality
     * then check if quality is not more than 50 (max from the spec)
     *
     * @param item
     */
    public void increaseQuality(Item item) {
        if (item.quality <= 0) item.quality = 0;
        item.quality++;
        if (item.quality >= 50) item.quality = 50;
    }

    /**
     * item.quality decrement
     * <p>
     * decrement item
     * then check if quality is less or equals from 0, if true, return 0 (min from the specs)
     *
     * @param item
     */
    public void decreaseQuality(Item item) {
        item.quality--;
        if (item.quality <= 0) item.quality = 0;
    }

    /**
     * useless method, there from the beginning
     *
     * @return array of Item
     */
    public Item[] getItems() {
        return items;
    }
}