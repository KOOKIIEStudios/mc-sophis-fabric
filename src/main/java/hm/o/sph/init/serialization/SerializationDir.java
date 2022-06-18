package hm.o.sph.init.serialization;

import hm.o.sph.util.function.SideEffect;
import org.jetbrains.annotations.NotNull;

import java.io.File;

import static hm.o.sph.Sophis.LOGGER;

public class SerializationDir {
    public static final SideEffect init = () -> LOGGER.info("Initializing Sophis Folders. ");

    public static final SerializationDir MATERIAL_ITEM = SerializationApplier.createSerialization( "item", "material");
    public static final SerializationDir EQUIPMENT_ITEM = SerializationApplier.createSerialization( "item", "equipment");
    public static final SerializationDir CRAFT_ITEM = SerializationApplier.createSerialization("item", "craft");

    public final File folder;
    public final String id;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    protected SerializationDir(String id, @NotNull File folder) {
        this.id = id;
        this.folder = folder;
        folder.mkdirs();
    }
}
