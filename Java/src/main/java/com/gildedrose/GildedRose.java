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

    private void updateConjuredItems(Item item) {
        if (item.sellIn > 0)
            item.quality -= 2;
        else
            item.quality -= 4;

        if (item.quality < 0)
            item.quality = 0;
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
            else if (item.name.equals("Conjured Mana Cake"))
                updateConjuredItems(item);
            else
                updateOtherItems(item);
        }
    }
}