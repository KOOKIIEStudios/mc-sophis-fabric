package hm.o.sph.init.item;

import hm.o.sph.util.SophisRarity;
import net.minecraft.item.Item;

public class SophisItem extends Item {
    public final ItemCategory category;
    public final int credit;
    public final SophisRarity rarity;

    protected SophisItem(Settings settings, ItemCategory category, int credit, SophisRarity rarity) {
        super(settings);
        this.category = category;
        this.credit = credit;
        this.rarity = rarity;
    }
}
