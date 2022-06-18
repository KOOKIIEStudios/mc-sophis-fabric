package hm.o.sph;

import hm.o.sph.init.item.ItemCategory;
import hm.o.sph.init.item.SophisItems;
import hm.o.sph.init.item.SophisGroups;
import hm.o.sph.init.serialization.Deserialization;
import hm.o.sph.init.serialization.SerializationApplier;
import hm.o.sph.init.serialization.SerializationDir;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
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

        var YAML_FILES = new HashSet<Deserialization.Item.Material>();
        var TOML_FILES = new HashSet<Deserialization.Item.Material>();
        var JSON_FILES = new HashSet<Deserialization.Item.Material>();

        Arrays.stream(Objects.requireNonNull(SerializationDir.MATERIAL_ITEM.folder.listFiles())).forEach(file -> {
            try {
                if(SerializationApplier.checkYAMLExtName(file)) {
                    YAML_FILES.add(SerializationApplier.YAML.readValue(file, Deserialization.Item.Material.class));
                } else if(SerializationApplier.checkTOMLExtName(file)) {
                    TOML_FILES.add(SerializationApplier.TOML.readValue(file, Deserialization.Item.Material.class));
                } else if(SerializationApplier.checkJSONExtName(file)) {
                    JSON_FILES.add(SerializationApplier.JSON.readValue(file, Deserialization.Item.Material.class));
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
            YAML_FILES.forEach(obj -> System.out.println(obj.getId() + "::" + obj.getCategory() + "::" + obj.getRarity() + "::" + obj.getCredit()));
            TOML_FILES.forEach(obj -> System.out.println(obj.getId() + "::" + obj.getCategory() + "::" + obj.getRarity() + "::" + obj.getCredit()));
            JSON_FILES.forEach(obj -> System.out.println(obj.getId() + "::" + obj.getCategory() + "::" + obj.getRarity() + "::" + obj.getCredit()));
        });
    }
}
