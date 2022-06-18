package hm.o.sph.init.item;

import hm.o.sph.util.SophisRarity;
import hm.o.sph.util.function.SideEffect;

import static hm.o.sph.Sophis.LOGGER;

public class SophisItems {

    public static final SideEffect init = () -> LOGGER.info("Initialize Sophis Items.");

    public static final SophisItem SPHALERITE_MIXTURE;
    public static final SophisItem IRON_METEORITE_MIXTURE;

    static {
        SPHALERITE_MIXTURE = ItemApplier.buildItem("sphalerite_mixture").category(ItemCategory.MATERIAL_ORE).rarity(SophisRarity.COMMON).credit(20).idle.get();
        IRON_METEORITE_MIXTURE = ItemApplier.buildItem("iron_meteorite_mixture").category(ItemCategory.MATERIAL_ORE).rarity(SophisRarity.COMMON).credit(20).idle.get();
    }
}
