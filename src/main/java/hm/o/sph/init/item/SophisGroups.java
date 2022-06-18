package hm.o.sph.init.item;

import static hm.o.sph.Sophis.LOGGER;
import static hm.o.sph.Sophis.MODID;
import static net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder.build;

import hm.o.sph.util.function.SideEffect;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class SophisGroups {

    public static final SideEffect init = () -> LOGGER.info("Initialize Sophis Groups.");
    public static final ItemGroup MATERIAL = build(Identifier.of(MODID, "material"), () -> new ItemStack(Items.BONE));
    public static final ItemGroup EQUIPMENT = build(Identifier.of(MODID, "equipment"), () -> new ItemStack(Items.BONE));
    public static final ItemGroup CRAFT = build(Identifier.of(MODID, "craft"), () -> new ItemStack(Items.BONE));
    public static final ItemGroup CONSUMABLES = build(Identifier.of(MODID, "consumables"), () -> new ItemStack(Items.BONE));
}
