package hm.o.sph;

import hm.o.sph.init.attribute.Attribute;
import hm.o.sph.init.attribute.Imprint;
import hm.o.sph.util.function.SideEffect;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static hm.o.sph.Sophis.LOGGER;
import static hm.o.sph.Sophis.MODID;

public class SophisRegistries {

    public static final SideEffect init = () -> LOGGER.info("Initialize Sophis Registries.");
    public static final Registry<Attribute> ATTRIBUTE = Builder.apply(Attribute.class).registryId("attribute").defaultId("stage_level").idle().get();
    public static final Registry<Imprint> IMPRINT = Builder.apply(Imprint.class).registryId("imprint").defaultId("empty").idle().get();

    public static class Builder<T> {
        private Class<T> type;
        private String defaultId;
        private String registryId;

        @Contract(value = "_ -> new", pure = true)
        public static <U> @NotNull Builder<U> apply(Class<U> type) {
            return new Builder<>();
        }

        public Builder<T> defaultId(String defaultId) {
            this.defaultId = defaultId;
            return this;
        }

        public Builder<T> registryId(String registryId) {
            this.registryId = registryId;
            return this;
        }

        public Supplier<DefaultedRegistry<T>> idle() {
            return () -> FabricRegistryBuilder.createDefaulted(type, new Identifier(MODID, registryId), new Identifier(MODID, defaultId)).buildAndRegister();
        }
    }
}
