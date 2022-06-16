package hm.o.sph.init.attribute;

import hm.o.sph.SophisRegistries;
import hm.o.sph.util.Math;
import net.minecraft.util.registry.RegistryEntry;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Attribute {

    protected final RegistryEntry.Reference<Attribute> regEntry;

    protected Attribute() {
        regEntry = SophisRegistries.ATTRIBUTE.createEntry(this);
    }

    @Contract(value = " -> new", pure = true)
    public static @NotNull Attribute apply() {
        return new Attribute();
    }

    public static class Undefined {

        protected Undefined(Attribute base, int min, int max) {
            this.base = base;
            bound = Pair.of(min, max);
        }

        public final Attribute base;
        public final Pair<Integer, Integer> bound;

        @Contract(value = "_, _, _ -> new", pure = true)
        public static @NotNull Undefined of(Attribute base, int firstBound, int secondBound) {
            var min = java.lang.Math.min(firstBound, secondBound);
            var max = java.lang.Math.max(firstBound, secondBound);
            return new Undefined(base, min, max);
        }

        @Contract(value = "_ -> new", pure = true)
        public static @NotNull Stable toStable(@NotNull Undefined attr) {
            return Stable.of(attr, Math.random(attr.bound.getLeft(), attr.bound.getRight()));
        }
    }

    public static class Stable {

        protected Stable(Undefined origin, int current) {
            this.origin = origin;
            this.current = current;
        }

        public final Undefined origin;
        public final int current;

        @Contract(value = "_, _ -> new", pure = true)
        public static @NotNull Stable of(Undefined undefinedAttr, int attrValue) {
            return new Stable(undefinedAttr, attrValue);
        }

        @Contract(value = "_ -> new", pure = true)
        public static @NotNull Stable reset(@NotNull Stable stableAttr) {
            return new Stable(stableAttr.origin, Math.random(stableAttr.origin.bound.getLeft(), stableAttr.origin.bound.getRight()));
        }
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    public static @NotNull Undefined ofNewInstance(Attribute attr, int firstBound, int secondBound) {
        return Undefined.of(attr, firstBound, secondBound);
    }
}
