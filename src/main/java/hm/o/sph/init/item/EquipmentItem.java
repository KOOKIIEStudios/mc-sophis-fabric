package hm.o.sph.init.item;

import hm.o.sph.init.attribute.Attribute;
import hm.o.sph.init.attribute.Imprint;
import hm.o.sph.util.SophisRarity;

import java.util.HashSet;
import java.util.Set;

public class EquipmentItem extends SophisItem {
    public final Set<Imprint.Stable> imprints;
    public final boolean disposable;
    public final Set<Attribute.Undefined> basicAttrs;

    protected EquipmentItem(Settings settings, Set<Attribute.Undefined> basicAttrs, ItemCategory category, int credit, SophisRarity rarity, boolean disposable) {
        super(settings, category, credit, rarity);
        this.disposable = disposable;
        this.basicAttrs = basicAttrs;
        imprints = new HashSet<>();
    }
}
