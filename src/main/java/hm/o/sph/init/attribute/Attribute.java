package hm.o.sph.init.attribute;

import hm.o.sph.SophisRegistries;
import net.minecraft.util.registry.RegistryEntry;
import org.apache.commons.lang3.tuple.Pair;

public class Attribute {
    protected final RegistryEntry.Reference<Attribute> regEntry;
    protected Attribute() {
        regEntry = SophisRegistries.ATTRIBUTE.createEntry(this);
    }

    public static class Undefined {
        public final Attribute base;
        public final Pair<Integer, Integer> bound;
        protected Undefined(Attribute base, int min, int max) {
            this.base = base;
            bound = Pair.of(min, max);
        }
    }

    public static class Stable {
        public final Undefined origin;
        public final int current;
        protected Stable(Undefined origin, int current) {
            this.origin = origin;
            this.current = current;
        }
    }
}
