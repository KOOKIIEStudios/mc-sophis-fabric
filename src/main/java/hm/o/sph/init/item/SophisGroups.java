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
    public static final ItemGroup MATERIAL = build(new Identifier(MODID, "material"), () -> new ItemStack(Items.BONE));
    public static final ItemGroup EQUIPMENT = build(new Identifier(MODID, "equipment"), () -> new ItemStack(Items.BONE));
    public static final ItemGroup CONSUMABLES = build(new Identifier(MODID, "consumables"), () -> new ItemStack(Items.BONE));
}
