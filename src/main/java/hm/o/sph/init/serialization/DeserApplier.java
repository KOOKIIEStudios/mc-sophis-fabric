package hm.o.sph.init.serialization;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.toml.TomlFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.io.FilenameUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

import static hm.o.sph.Sophis.ROOT;

public class DeserApplier {

    public static final ObjectMapper YAML = new ObjectMapper(new YAMLFactory());
    public static final ObjectMapper TOML = new ObjectMapper(new TomlFactory());
    public static final ObjectMapper JSON = new ObjectMapper(new JsonFactory());

    // region DESERIALIZED FOLDER

    @Contract(value = "_, _ -> new", pure = true)
    private static @NotNull File hierarchicallyGet(String fst, String sec) {
        return new File( new File(ROOT, fst), sec);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull DeserDir createDeserDir(String fstLayer, String secLayer) {
        return new DeserDir( secLayer + "_" + fstLayer, hierarchicallyGet(fstLayer, secLayer));
    }

    public static boolean checkExistenceOfDir(@NotNull DeserDir serData) {
        return serData.folder.exists();
    }

    // endregion

    // region DESERIALIZING CHECKER

    public static boolean checkYAMLExtName(@NotNull File file) {
        return FilenameUtils.getExtension(file.getName()).equals("yaml") || FilenameUtils.getExtension(file.getName()).equals("yml");
    }

    public static boolean checkTOMLExtName(@NotNull File file) {
        return FilenameUtils.getExtension(file.getName()).equals("toml");
    }

    public static boolean checkJSONExtName(@NotNull File file) {
        return FilenameUtils.getExtension(file.getName()).equals("json");
    }

    // endregion

    //region DESERIALIZATION

    public static <T> T deser(@NotNull ObjectMapper mapper, File file, Class<T> type) {
        T result = null;
        try {
            result = mapper.readValue(file, type);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //endregion
}
