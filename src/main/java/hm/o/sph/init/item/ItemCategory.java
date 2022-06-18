package hm.o.sph.init.item;

import hm.o.sph.util.function.SideEffect;
import net.minecraft.item.ItemGroup;

import static hm.o.sph.Sophis.LOGGER;

public class ItemCategory {
    public static final SideEffect init = () -> LOGGER.info("Initialize Sophis Item Categories.");

    public static final ItemCategory MATERIAL_ORE = ItemApplier.createCategory("material_ore", SophisGroups.MATERIAL);
    public static final ItemCategory MATERIAL_ROCK = ItemApplier.createCategory("material_rock", SophisGroups.MATERIAL);
    public static final ItemCategory MATERIAL_WOOD = ItemApplier.createCategory("material_wood", SophisGroups.MATERIAL);
    public static final ItemCategory MATERIAL_SKIN = ItemApplier.createCategory("material_skin", SophisGroups.MATERIAL);
    public static final ItemCategory MATERIAL_PLANT = ItemApplier.createCategory("material_plant", SophisGroups.MATERIAL);
    public static final ItemCategory MATERIAL_ORGAN = ItemApplier.createCategory("material_organ", SophisGroups.MATERIAL);
    public static final ItemCategory MATERIAL_MIND = ItemApplier.createCategory("material_mind", SophisGroups.MATERIAL);
    public static final ItemCategory MATERIAL_AROMA = ItemApplier.createCategory("material_aroma", SophisGroups.MATERIAL);
    public static final ItemCategory MATERIAL_FLUID = ItemApplier.createCategory("material_fluid", SophisGroups.MATERIAL);
    @Deprecated public static final ItemCategory MATERIAL_TEMP = ItemApplier.createCategory("material_temp", SophisGroups.MATERIAL);

    public static final ItemCategory EQUIPMENT_WEAPON = ItemApplier.createCategory("equipment_weapon", SophisGroups.EQUIPMENT);
    public static final ItemCategory EQUIPMENT_OFFHAND = ItemApplier.createCategory("equipment_offhand", SophisGroups.EQUIPMENT);
    public static final ItemCategory EQUIPMENT_HELMET = ItemApplier.createCategory("equipment_helmet", SophisGroups.EQUIPMENT);
    public static final ItemCategory EQUIPMENT_BODY = ItemApplier.createCategory("equipment_body", SophisGroups.EQUIPMENT);
    public static final ItemCategory EQUIPMENT_BELT = ItemApplier.createCategory("equipment_belt", SophisGroups.EQUIPMENT);
    public static final ItemCategory EQUIPMENT_GLOVES = ItemApplier.createCategory("equipment_gloves", SophisGroups.EQUIPMENT);
    public static final ItemCategory EQUIPMENT_BOOTS = ItemApplier.createCategory("equipment_boots", SophisGroups.EQUIPMENT);
    public static final ItemCategory EQUIPMENT_RING = ItemApplier.createCategory("equipment_ring", SophisGroups.EQUIPMENT);
    public static final ItemCategory EQUIPMENT_AMULET = ItemApplier.createCategory("equipment_amulet", SophisGroups.EQUIPMENT);
    public static final ItemCategory EQUIPMENT_BOOKMARK = ItemApplier.createCategory("equipment_bookmark", SophisGroups.EQUIPMENT);

    public static final ItemCategory CRAFT_VIANA = ItemApplier.createCategory("craft_viana", SophisGroups.CRAFT);

    public final ItemGroup group;
    public final String id;

    protected ItemCategory(ItemGroup group, String id) {
        this.group = group;
        this.id = id;
    }
}
