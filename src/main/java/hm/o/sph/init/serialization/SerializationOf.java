package hm.o.sph.init.serialization;

import static hm.o.sph.Sophis.FABRIC;

import org.jetbrains.annotations.NotNull;

import java.io.File;

public enum SerializationOf {
    ROOT(new File(FABRIC.getGameDir().toFile(), "sophis"), "sophis"),
    ITEM(new File(ROOT.folder, "item"), "item"),
    IMPRINT(new File(ROOT.folder, "imprint"), "imprint");

    SerializationOf(@NotNull File folder, @NotNull String id) {
        this.folder = folder;
        this.id = id;
    }

    public final File folder;
    public final String id;
}
