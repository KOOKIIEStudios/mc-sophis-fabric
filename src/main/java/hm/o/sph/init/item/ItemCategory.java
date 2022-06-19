package hm.o.sph.init.item;

import hm.o.sph.util.function.SideEffect;
import net.minecraft.item.ItemGroup;
import org.jetbrains.annotations.NotNull;

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
    @SuppressWarnings("DeprecatedIsStillUsed")
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

    private static final ItemCategory[] values = new ItemCategory[] {
            MATERIAL_ORE, MATERIAL_ROCK, MATERIAL_WOOD, MATERIAL_SKIN, MATERIAL_PLANT, MATERIAL_ORGAN, MATERIAL_MIND, MATERIAL_AROMA, MATERIAL_FLUID,
            MATERIAL_TEMP, EQUIPMENT_WEAPON, EQUIPMENT_OFFHAND, EQUIPMENT_HELMET, EQUIPMENT_BODY, EQUIPMENT_GLOVES, EQUIPMENT_BOOTS, EQUIPMENT_RING,
            EQUIPMENT_AMULET, EQUIPMENT_BOOKMARK, CRAFT_VIANA
    };

    public final ItemGroup group;
    public final String id;

    protected ItemCategory(ItemGroup group, String id) {
        this.group = group;
        this.id = id;
    }

    public static ItemCategory[] values() {
        return values.clone();
    }

    public static @NotNull ItemCategory valueOf(String name) {
        return getById(name);
    }

    public static @NotNull ItemCategory getById(String id) {
        for(var val : ItemCategory.values()) {
            if(val.id.equalsIgnoreCase(id)) {
                return val;
            }
        }
        throw new IllegalArgumentException("Wrong identifier to check Item Category");
    }
}
