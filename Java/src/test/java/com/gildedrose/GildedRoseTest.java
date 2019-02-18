package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    // ===================================================
    // Aged Brie: Quality = [0, 50]
    // SellIn - unbounded integer

    // ---------------------------------------------------
    // Aged Brie: sellIn > 0 (always decreases by 1), quality += 1;
    @Test
    public void AgedBrieTest1() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie SellIn failed", 1, app.items[0].sellIn);
        assertEquals("Aged Brie Quality failed", 1, app.items[0].quality);
    }
    // ---------------------------------------------------

    // ---------------------------------------------------
    // Aged Brie: sellIn = 0 (always decreases by 1), quality += 2;
    @Test
    public void AgedBrieTest2() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie SellIn failed", -1, app.items[0].sellIn);
        assertEquals("Aged Brie Quality failed", 2, app.items[0].quality);
    }
    // ---------------------------------------------------

    // ---------------------------------------------------
    // Aged Brie: sellIn = 0 (always decreases by 1), quality cannot be greater than
    // 50;
    @Test
    public void AgedBrieTest3() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie SellIn failed", -1, app.items[0].sellIn);
        assertEquals("Aged Brie Quality failed", 50, app.items[0].quality);
    }
    // ---------------------------------------------------

    // ---------------------------------------------------
    // Aged Brie: sellIn < 0 (always decreases by 1), quality cannot be greater than
    // 50;
    @Test
    public void AgedBrieTest4() {
        Item[] items = new Item[] { new Item("Aged Brie", -2, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie SellIn failed", -3, app.items[0].sellIn);
        assertEquals("Aged Brie Quality failed", 50, app.items[0].quality);
    }
    // ---------------------------------------------------
    // ===================================================

    // ===================================================
    // Sulfuras: const quality = 80
    // SellIn - constant

    // ---------------------------------------------------
    // Sulfuras: sellIn = 0 (remains constant), const quality = 80
    @Test
    public void SulfurasTest1() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras SellIn failed", 0, app.items[0].sellIn);
        assertEquals("Sulfuras Quality failed", 80, app.items[0].quality);
    }
    // ---------------------------------------------------

    // ---------------------------------------------------
    // Sulfuras: sellIn > 0 (remains constant), const quality = 80
    @Test
    public void SulfurasTest2() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras SellIn failed", 1, app.items[0].sellIn);
        assertEquals("Sulfuras Quality failed", 80, app.items[0].quality);
    }
    // ---------------------------------------------------

    // ---------------------------------------------------
    // Sulfuras: sellIn < 0 (remains constant), const quality = 80
    @Test
    public void SulfurasTest3() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -2000, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras SellIn failed", -2000, app.items[0].sellIn);
        assertEquals("Sulfuras Quality failed", 80, app.items[0].quality);
    }
    // ---------------------------------------------------

    // ===================================================
    // Backstage passes: Quality = [0, 50]
    // SellIn - unbounded integer

    // ---------------------------------------------------
    // Backstage passes: sellIn > 10 (always decreases by 1), quality += 1;
    @Test
    public void BackstagePassesTest1() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes SellIn failed", 14, app.items[0].sellIn);
        assertEquals("Backstage passes Quality failed", 21, app.items[0].quality);

    }

    // ---------------------------------------------------
    // Backstage passes: sellIn = 10 (always decreases by 1), quality += 2;
    @Test
    public void BackstagePassesTest2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes SellIn failed", 9, app.items[0].sellIn);
        assertEquals("Backstage passes Quality failed", 17, app.items[0].quality);
    }
    // ---------------------------------------------------

    // ---------------------------------------------------
    // Backstage passes: 10 > sellIn > 5 (always decreases by 1), quality += 2;
    @Test
    public void BackstagePassesTest3() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes SellIn failed", 8, app.items[0].sellIn);
        assertEquals("Backstage passes Quality failed", 17, app.items[0].quality);
    }
    // ---------------------------------------------------

    // ---------------------------------------------------
    // Backstage passes: sellIn = 5 (always decreases by 1), quality += 3;
    @Test
    public void BackstagePassesTest4() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes SellIn failed", 4, app.items[0].sellIn);
        assertEquals("Backstage passes Quality failed", 48, app.items[0].quality);
    }
    // ---------------------------------------------------

    // ---------------------------------------------------
    // Backstage passes: 5 > sellIn > 0 (always decreases by 1), quality += 3;
    @Test
    public void BackstagePassesTest5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 33) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes SellIn failed", 3, app.items[0].sellIn);
        assertEquals("Backstage passes Quality failed", 36, app.items[0].quality);
    }
    // --------------------------------------------------

    // ---------------------------------------------------
    // Backstage passes: sellIn = 0 (always decreases by 1), quality = 0;
    @Test
    public void BackstagePassesTest6() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 48) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes SellIn failed", -1, app.items[0].sellIn);
        assertEquals("Backstage passes Quality failed", 0, app.items[0].quality);
    }
    // --------------------------------------------------

    // ---------------------------------------------------
    // Backstage passes: sellIn < 0 (always decreases by 1), quality = 0;
    @Test
    public void BackstagePassesTest7() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes SellIn failed", -11, app.items[0].sellIn);
        assertEquals("Backstage passes Quality failed", 0, app.items[0].quality);
    }

    // --------------------------------------------------

    // ---------------------------------------------------
    // Backstage passes: 5 > sellIn > 0 (always decreases by 1), quality = 55;
    @Test
    public void BackstagePassesTest8() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes SellIn failed", 2, app.items[0].sellIn);
        assertEquals("Backstage passes Quality failed", 50, app.items[0].quality);
    }
    // ===================================================

    // ===================================================
    // Others: Quality = [0, 50]
    // SellIn - unbounded integer

    // ---------------------------------------------------
    // Others: Other Item sellIn > 0 (always decreases by 1), quality -= 1;
    @Test
    public void OthersTest1() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Other Item SellIn failed", 9, app.items[0].sellIn);
        assertEquals("Other Item Quality failed", 19, app.items[0].quality);
    }
    // ---------------------------------------------------

    // ---------------------------------------------------
    // Others: Other Item sellIn = 0 (always decreases by 1), quality -= 2;
    @Test
    public void OthersTest2() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Other Item SellIn failed", -1, app.items[0].sellIn);
        assertEquals("Other Item Quality failed", 48, app.items[0].quality);
    }
    // ---------------------------------------------------

    // ---------------------------------------------------
    // Others: Other Item sellIn < 0 (always decreases by 1), quality -= 2;
    @Test
    public void OthersTest3() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", -4000, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Other Item SellIn failed", -4001, app.items[0].sellIn);
        assertEquals("Other Item Quality failed", 23, app.items[0].quality);
    }
    // ---------------------------------------------------

    // ---------------------------------------------------
    // Others: quality = 0;
    @Test
    public void OthersTest4() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 15, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Other Item SellIn failed", 14, app.items[0].sellIn);
        assertEquals("Other Item Quality failed", 0, app.items[0].quality);
    }
    // ---------------------------------------------------

    // ===================================================
    // Conjured Items: Quality = [0, 50]
    // SellIn - unbounded integer

    // ---------------------------------------------------
    // Conjured: Conjured Item sellIn > 0 (always decreases by 1), quality degrades
    // twice as fast;
    @Test
    public void ConjuredItemsTest1() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Other Item SellIn failed", 2, app.items[0].sellIn);
        assertEquals("Other Item Quality failed", 4, app.items[0].quality);
    }
    // ---------------------------------------------------

    // ---------------------------------------------------
    // Conjured: Conjured Item sellIn = 0 (always decreases by 1), quality degrades
    // twice as fast;
    @Test
    public void ConjuredItemsTest2() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Other Item SellIn failed", -1, app.items[0].sellIn);
        assertEquals("Other Item Quality failed", 16, app.items[0].quality);
    }
    // ---------------------------------------------------//

    // ---------------------------------------------------
    // Conjured: Conjured Item sellIn < 0 (always decreases by 1), quality degrades
    // twice as fast
    @Test
    public void ConjuredItemsTest3() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Other Item SellIn failed", -4, app.items[0].sellIn);
        assertEquals("Other Item Quality failed", 2, app.items[0].quality);
    }
    // ---------------------------------------------------//

    // ---------------------------------------------------
    // Conjured: Conjured Item sellIn = 0 (always decreases by 1), quality degrades
    // twice as fast
    @Test
    public void ConjuredItemsTest4() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Other Item SellIn failed", -1, app.items[0].sellIn);
        assertEquals("Other Item Quality failed", 0, app.items[0].quality);
    }
    // ---------------------------------------------------

}
