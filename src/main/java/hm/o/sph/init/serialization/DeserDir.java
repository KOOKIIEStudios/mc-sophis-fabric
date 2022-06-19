package hm.o.sph.init.serialization;

import hm.o.sph.util.function.SideEffect;
import org.jetbrains.annotations.NotNull;

import java.io.File;

import static hm.o.sph.Sophis.LOGGER;

public class DeserDir {
    public static final SideEffect init = () -> LOGGER.info("Initializing Sophis Folders. ");

    public static final DeserDir MATERIAL_ITEM = DeserApplier.createDeserDir( "item", "material");
    public static final DeserDir EQUIPMENT_ITEM = DeserApplier.createDeserDir( "item", "equipment");
    public static final DeserDir CRAFT_ITEM = DeserApplier.createDeserDir("item", "craft");

    public final File folder;
    public final String id;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    protected DeserDir(String id, @NotNull File folder) {
        this.id = id;
        this.folder = folder;
        folder.mkdirs();
    }
}
