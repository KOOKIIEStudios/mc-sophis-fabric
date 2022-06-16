package hm.o.sph.init.item;

import net.minecraft.item.ItemGroup;

public enum ItemCategory {

    MATERIAL_METAL(SophisGroups.MATERIAL, "material_metal"),
    MATERIAL_GEM(SophisGroups.MATERIAL, "material_gem"),
    MATERIAL_ROCK(SophisGroups.MATERIAL, "material_rock"),
    MATERIAL_WOOD(SophisGroups.MATERIAL, "material_wood"),
    MATERIAL_LEATHER(SophisGroups.MATERIAL, "material_leather"),
    MATERIAL_PLANT(SophisGroups.MATERIAL, "material_plant"),
    MATERIAL_ORGAN(SophisGroups.MATERIAL, "material_organ"),
    MATERIAL_MIND(SophisGroups.MATERIAL, "material_mind"),
    MATERIAL_SECRETION(SophisGroups.MATERIAL, "material_secretion"),
    MATERIAL_MIXTURE(SophisGroups.MATERIAL, "material_mixture"),

    EQUIPMENT_WEAPON(SophisGroups.EQUIPMENT, "equipment_weapon"),
    EQUIPMENT_OFFHAND(SophisGroups.EQUIPMENT, "equipment_offhand"),
    EQUIPMENT_HELMET(SophisGroups.EQUIPMENT, "equipment_helmet"),
    EQUIPMENT_BODY(SophisGroups.EQUIPMENT, "equipment_body"),
    EQUIPMENT_BELT(SophisGroups.EQUIPMENT, "equipment_belt"),
    EQUIPMENT_GLOVES(SophisGroups.EQUIPMENT, "equipment_gloves"),
    EQUIPMENT_BOOTS(SophisGroups.EQUIPMENT, "equipment_boots"),
    EQUIPMENT_RING(SophisGroups.EQUIPMENT, "equipment_ring"),
    EQUIPMENT_AMULET(SophisGroups.EQUIPMENT, "equipment_amulet"),
    EQUIPMENT_BOOKMARK(SophisGroups.EQUIPMENT, "equipment_bookmark");



    ItemCategory(ItemGroup group, String id) {
        this.group = group;
        this.id = id;
    }

    public final ItemGroup group;
    public final String id;

    @Override
    public String toString() {
        return this.id;
    }
}
