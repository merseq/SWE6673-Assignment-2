package com.gildedrose;

import javax.lang.model.util.ElementScanner6;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void updateAgedBrie(Item item) {
        if (item.sellIn > 0)
            item.quality += 1;
        else
            item.quality += 2;

        if (item.quality > 50)
            item.quality = 50;
    }

    private void updateBackstagePasses(Item item) {
        if (item.sellIn > 10)
            item.quality += 1;
        else if (item.sellIn > 5)
            item.quality += 2;
        else if (item.sellIn > 0)
            item.quality += 3;
        else
            item.quality = 0;

        if (item.quality > 50)
            item.quality = 50;
    }

    private void updateOtherItems(Item item) {
        if (item.sellIn > 0)
            item.quality -= 1;
        else
            item.quality -= 2;

        if (item.quality < 0)
            item.quality = 0;
    }

    public void updateQuality() {
        for (Item item : items) {
            item.sellIn -= 1;
            if (item.name.equals("Aged Brie"))
                updateAgedBrie(item);
            else if (item.name.equals("Sulfuras, Hand of Ragnaros"))
                item.sellIn += 1;
            else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
                updateBackstagePasses(item);
            else
                updateOtherItems(item);

        }
    }

    // for (int i = 0; i < items.length; i++) {
    // if (!items[i].name.equals("Aged Brie")
    // && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
    // if (items[i].quality > 0) {
    // if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
    // items[i].quality = items[i].quality - 1;
    // }
    // }
    // } else {
    // if (items[i].quality < 50) {
    // items[i].quality = items[i].quality + 1;

    // if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
    // if (items[i].sellIn < 11) {
    // if (items[i].quality < 50) {
    // items[i].quality = items[i].quality + 1;
    // }
    // }

    // if (items[i].sellIn < 6) {
    // if (items[i].quality < 50) {
    // items[i].quality = items[i].quality + 1;
    // }
    // }
    // }
    // }
    // }

    // if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
    // items[i].sellIn = items[i].sellIn - 1;
    // }

    // if (items[i].sellIn < 0) {
    // if (!items[i].name.equals("Aged Brie")) {
    // if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
    // if (items[i].quality > 0) {
    // if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
    // items[i].quality = items[i].quality - 1;
    // }
    // }
    // } else {
    // items[i].quality = items[i].quality - items[i].quality;
    // }
    // } else {
    // if (items[i].quality < 50) {
    // items[i].quality = items[i].quality + 1;
    // }
    // }
    // }
    // }
    // }

}