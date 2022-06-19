package hm.o.sph.init.serialization;

import java.util.function.Supplier;

public interface Registrable<T> {
    T register();

    default Supplier<T> toFunction() {
        return this::register;
    }
}
