package com.gildedrose;

public class Item {

    public String name;
    public int sellIn;
    public int quality;

    /**
     * constructor
     *
     * @param name
     * @param sellIn
     * @param quality
     */
    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    /**
     * isConjured ?
     * if name start with 'Conjured', return true
     *
     * @return boolean
     */
    boolean isConjured() {
        return this.name.startsWith("Conjured");
    }

    /**
     * isLegendary ?
     * if name equals 'Sulfuras, Hand of Ragnarso, return true
     *
     * @return boolean
     */
    boolean isLegendary() {
        return this.name.equals("Sulfuras, Hand of Ragnaros");
    }

    /**
     * isAPass ?
     * if name start with 'Backstage passes', return true
     *
     * @return boolean
     */
    boolean isAPass() {
        return this.name.startsWith("Backstage passes");
    }

    /**
     * isCheese ?
     * if name equals "Aged Brie", return true
     *
     * @return boolean
     */
    boolean isCheese() {
        return this.name.equals("Aged Brie");
    }

    /**
     * isSoldOut ?
     * if sellIn in less than 0, return true
     *
     * @return
     */
    boolean isSoldOut() {
        return this.sellIn < 0;
    }

    /**
     * isSoldOut ?
     * if sellIn in less than 0, return true
     *
     * @return
     */
    boolean isSoldOutC() {
        return this.sellIn < -100;
    }

    /**
     * isWine ?
     * if sellIn >= 0, quality is stable
     *
     * @return
     */
    boolean isWine() {
        return this.name.startsWith("Aging");
    }


    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
