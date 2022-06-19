package hm.o.sph;

import hm.o.sph.init.item.ItemCategory;
import hm.o.sph.init.item.SophisGroups;
import hm.o.sph.init.item.SophisItems;
import hm.o.sph.init.serialization.DeserApplier;
import hm.o.sph.init.serialization.DeserData;
import hm.o.sph.init.serialization.DeserDir;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class Sophis implements ModInitializer {
    public static final String MODID = "sph";
    public static final FabricLoader FABRIC = FabricLoader.getInstance();
    public static final File ROOT = new File(FABRIC.getGameDir().toFile(), "sophis");
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID.toUpperCase());

    @Override
    public void onInitialize() {
        SophisRegistries.init.effect();
        SophisGroups.init.effect();
        ItemCategory.init.effect();
        SophisItems.init.effect();
        //SerializationOf.init.effect();

        var materials = new HashSet<DeserData.Item.Material>();

        Arrays.stream(Objects.requireNonNull(DeserDir.MATERIAL_ITEM.folder.listFiles()))
                .filter(DeserApplier::checkYAMLExtName)
                .map(file -> DeserApplier.deser(DeserApplier.YAML, file, DeserData.Item.Material.class))
                .forEach(materials::add);
        Arrays.stream(Objects.requireNonNull(DeserDir.MATERIAL_ITEM.folder.listFiles()))
                .filter(DeserApplier::checkTOMLExtName)
                .map(file -> DeserApplier.deser(DeserApplier.TOML, file, DeserData.Item.Material.class))
                .forEach(materials::add);
        Arrays.stream(Objects.requireNonNull(DeserDir.MATERIAL_ITEM.folder.listFiles()))
                .filter(DeserApplier::checkJSONExtName)
                .map(file -> DeserApplier.deser(DeserApplier.JSON, file, DeserData.Item.Material.class))
                .forEach(materials::add);

        materials.forEach(System.out::println);
    }
}
