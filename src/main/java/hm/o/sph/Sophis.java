package hm.o.sph;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sophis implements ModInitializer {
    public static final String MODID = "sph";
    public static final FabricLoader FABRIC = FabricLoader.getInstance();
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID.toUpperCase());

    @Override
    public void onInitialize() {
        SophisRegistries.init.effect();
    }
}
