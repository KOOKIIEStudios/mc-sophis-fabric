package hm.o.sph.init.item;

import hm.o.sph.init.attribute.Attribute;
import hm.o.sph.init.attribute.Imprint;
import hm.o.sph.util.SophisRarity;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

import static hm.o.sph.Sophis.MODID;
import static net.minecraft.util.registry.Registry.ITEM;
import static net.minecraft.util.registry.Registry.register;

public class EquipmentItem extends SophisItem {

    protected EquipmentItem(Settings settings, Set<Attribute.Undefined> basicAttrs, ItemCategory category, int credit, SophisRarity rarity, boolean disposable) {
        super(settings, category, credit, rarity);
        this.disposable = disposable;
        this.basicAttrs = basicAttrs;
        imprints = new HashSet<>();
    }

    public final Set<Imprint.Stable> imprints;
    public final boolean disposable;
    public final Set<Attribute.Undefined> basicAttrs;

    public static class Builder {

        private String id;
        private ItemCategory category;
        private SophisRarity rarity;
        private int credit;
        private boolean disposable;
        private Set<Attribute.Undefined> basicAttrs;

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

        public Builder disposable(boolean disposable) {
            this.disposable = disposable;
            return this;
        }

        public Builder disposable() {
            this.disposable(true);
            return this;
        }

        public Builder basicAttrs(Attribute.Undefined... attrs) {
            this.basicAttrs = new HashSet<>();
            this.basicAttrs.addAll(Arrays.asList(attrs));
            return this;
        }

        public Supplier<EquipmentItem> idle() {
            return () -> register(ITEM, Identifier.of(MODID, id), new EquipmentItem(new Item.Settings().group(category.group), basicAttrs, category, credit, rarity, disposable));
        }

    }

    public static void addImprints(@NotNull EquipmentItem item, Imprint.Undefined... imprint) {
        item.imprints.addAll(Arrays.stream(imprint).map(Imprint.Undefined::toStable).toList());
    }
}
