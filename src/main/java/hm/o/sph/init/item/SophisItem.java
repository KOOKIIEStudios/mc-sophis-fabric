package hm.o.sph.init.item;

import static hm.o.sph.Sophis.MODID;
import static net.minecraft.util.registry.Registry.ITEM;
import static net.minecraft.util.registry.Registry.register;

import hm.o.sph.util.SophisRarity;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class SophisItem extends Item {

    protected SophisItem(Settings settings, ItemCategory category, int credit, SophisRarity rarity) {
        super(settings);
        this.category = category;
        this.credit = credit;
        this.rarity = rarity;
    }

    public final ItemCategory category;
    public final int credit;
    public final SophisRarity rarity;

    public static class Builder {

        private String id;
        private ItemCategory category;
        private SophisRarity rarity;
        private int credit;

        private Builder() {
        }

        public static @NotNull Builder apply(String id) {
            var b = new Builder();
            b.id = id;
            return b;
        }

        public Builder category(ItemCategory category) {
            this.category = category;
            return this;
        }

        public Builder rarity(SophisRarity rarity) {
            this.rarity = rarity;
            return this;
        }

        public Builder credit(int credit) {
            this.credit = credit;
            return this;
        }

        public Supplier<SophisItem> idle() {
            return () -> register(ITEM, Identifier.of(MODID, id), new SophisItem(new Item.Settings().group(category.group), category, credit, rarity));
        }
    }

}
