package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo("fixme");
    }

    @Test
    void aging() {
        Item[] items = new Item[] { new Item("Aging", -105, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(9);
    }

    @Test
    void aging2() {
        Item[] items = new Item[] { new Item("Aging", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(10);
    }

}
