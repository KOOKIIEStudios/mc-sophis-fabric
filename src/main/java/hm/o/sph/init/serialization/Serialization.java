package hm.o.sph.init.serialization;

import static hm.o.sph.Sophis.LOGGER;

import org.apache.commons.io.FileUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Optional;

public class Serialization {

    private static final int dirCount = 3;
    private static final String dotYaml = ".yaml";
    private static final String dotYml = ".yml";
    private static final String UTF_8 = "UTF-8";

    private Serialization() {
    }

    public static boolean defineSerdir() {
        var checkers = new Boolean[dirCount];

        checkers[0] = SerializationOf.ROOT.folder.mkdir();
        checkers[1] = SerializationOf.ITEM.folder.mkdir();
        checkers[2] = SerializationOf.IMPRINT.folder.mkdir();

        return Arrays.stream(checkers).filter((checker) -> checker.equals(Boolean.FALSE)).toList().size() == 0;
    }

    private static boolean existSerdir() {
        var checkers = new Boolean[dirCount];
        checkers[0] = Files.exists(SerializationOf.ROOT.folder.toPath());
        checkers[1] = Files.exists(SerializationOf.ITEM.folder.toPath());
        checkers[2] = Files.exists(SerializationOf.IMPRINT.folder.toPath());
        return Arrays.stream(checkers).filter((checker) -> checker.equals(Boolean.FALSE)).toList().size() == 0;
    }

    private static void deserialize() throws IOException {

        var yaml = new Yaml();

        var itemFiles = Optional.ofNullable(SerializationOf.ITEM.folder.listFiles((dir, name) -> name.endsWith(dotYaml) || name.endsWith(dotYml)));
        var imprintFiles = Optional.ofNullable(SerializationOf.IMPRINT.folder.listFiles(((dir, name) -> name.endsWith(dotYaml) || name.endsWith(dotYml))));

        if(itemFiles.isPresent()) {
            for(var itemFile : itemFiles.get()) {
                yaml.load(FileUtils.readFileToString(itemFile, UTF_8));
            }
        }
    }

    public static void apply() {
        if(Serialization.defineSerdir()) {
            if(!Serialization.existSerdir()) {
                LOGGER.warn("There aren't specific direction. Please check your instance folder.");
            } else {
                LOGGER.info("Start deserializing custom data.");
            }
        }
    }
}