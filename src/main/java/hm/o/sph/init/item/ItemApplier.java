package hm.o.sph.init.item;

import hm.o.sph.init.attribute.Attribute;
import hm.o.sph.init.attribute.AttributeApplier;
import hm.o.sph.init.attribute.Imprint;
import hm.o.sph.util.SophisRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

import static hm.o.sph.Sophis.MODID;
import static net.minecraft.util.registry.Registry.ITEM;
import static net.minecraft.util.registry.Registry.register;

public class ItemApplier {
    private ItemApplier() {
    }

    @Contract(value = "_, _ -> param1")
    public static @NotNull EquipmentItem increaseImp(@NotNull EquipmentItem item, @NotNull Set<Imprint.Undefined> imps) {
        if(AttributeApplier.checkUniqueImp(imps.iterator().next())) item.imprints.add(AttributeApplier.createStableImp(imps.iterator().next()));
        else item.imprints.addAll(imps.stream().filter(AttributeApplier::checkNormalImp).map(AttributeApplier::createStableImp).toList());
        return item;
    }

    public static @NotNull NormalBuilder buildItem(String id) {
        var b = new NormalBuilder();
        b.id = id;
        return b;
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull ItemCategory createCategory(String id, ItemGroup inVanilla) {
        return new ItemCategory(inVanilla, id);
    }

    public static class NormalBuilder {
        protected String id;
        protected ItemCategory category;
        protected SophisRarity rarity;
        protected int credit;

        public Supplier<SophisItem> idle = () -> register(ITEM, Identifier.of(MODID, id),
                new SophisItem(new Item.Settings().group(category.group), category, credit, rarity));

        protected NormalBuilder() {
        }

        public NormalBuilder category(ItemCategory category) {
            this.category = category;
            return this;
        }

        public NormalBuilder rarity(SophisRarity rarity) {
            this.rarity = rarity;
            return this;
        }

        public NormalBuilder credit(int credit) {
            this.credit = credit;
            return this;
        }

        public EquipmentBuilder toEquipmentBuilder() {
            var b = new EquipmentBuilder();
            b.id = id;
            b.category = category;
            b.rarity = rarity;
            b.credit = credit;
            return b;
        }
    }

    public static class EquipmentBuilder extends NormalBuilder {
        private boolean disposable;
        private Set<Attribute.Undefined> basicAttrs;

        public Supplier<EquipmentItem> idle = () -> register(ITEM, Identifier.of(MODID, id),
                new EquipmentItem(new Item.Settings().group(category.group), basicAttrs, category, credit, rarity, disposable));

        protected EquipmentBuilder() {
        }

        public EquipmentBuilder disposable(boolean disposable) {
            this.disposable = disposable;
            return this;
        }

        public EquipmentBuilder disposable() {
            this.disposable = true;
            return this;
        }

        public EquipmentBuilder basicAttrs(Attribute.Undefined... attrs) {
            this.basicAttrs = new HashSet<>(Arrays.stream(attrs).toList());
            return this;
        }
    }
}
