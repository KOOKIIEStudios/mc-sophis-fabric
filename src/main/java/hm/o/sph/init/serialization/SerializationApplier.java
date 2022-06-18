package hm.o.sph.init.serialization;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.toml.TomlFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.io.FilenameUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.yaml.snakeyaml.Yaml;

import java.io.File;

import static hm.o.sph.Sophis.ROOT;

public class SerializationApplier {

    public static final ObjectMapper YAML = new ObjectMapper(new YAMLFactory());
    public static final ObjectMapper TOML = new ObjectMapper(new TomlFactory());
    public static final ObjectMapper JSON = new ObjectMapper(new JsonFactory());

    // region FILE OR FOLD BEFORE SERIALIZING

    @Contract(value = "_, _ -> new", pure = true)
    private static @NotNull File hierarchicallyGet(String fst, String sec) {
        return new File( new File(ROOT, fst), sec);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull SerializationDir createSerialization(String fstLayer, String secLayer) {
        return new SerializationDir( secLayer + "_" + fstLayer, hierarchicallyGet(fstLayer, secLayer));
    }

    public static boolean checkExistenceOfDir(@NotNull SerializationDir serData) {
        return serData.folder.exists();
    }

    // endregion

    // region DESERIALIZING

    public static boolean checkYAMLExtName(@NotNull File file) {
        return FilenameUtils.getExtension(file.getName()).equals("yaml") || FilenameUtils.getExtension(file.getName()).equals("yml");
    }

    public static boolean checkTOMLExtName(@NotNull File file) {
        return FilenameUtils.getExtension(file.getName()).equals("toml");
    }

    public static boolean checkJSONExtName(@NotNull File file) {
        return FilenameUtils.getExtension(file.getName()).equals("json");
    }

    public static boolean checkXMLExtName(@NotNull File file) {
        return FilenameUtils.getExtension(file.getName()).equals("xml");
    }

    public static void deserialization(@NotNull File file) {
    }
    // endregion
}
