package hm.o.sph.init.attribute;

import hm.o.sph.SophisRegistries;
import hm.o.sph.util.Tier;
import net.minecraft.util.registry.RegistryEntry;

import java.util.Set;

public class Imprint {
    protected final RegistryEntry.Reference<Imprint> regEntry;
    public final Tier tier;
    public final Set<Attribute> attrs;
    public final ImprintSeries series;
    protected Imprint(Tier tier, ImprintSeries series, Set<Attribute> attrs) {
        regEntry = SophisRegistries.IMPRINT.createEntry(this);
        this.tier = tier;
        this.series = series;
        this.attrs = attrs;
    }

    public static class Undefined {
        public final Imprint base;
        public final Set<Attribute.Undefined> attrs;
        protected Undefined(Imprint base, Set<Attribute.Undefined> attrs) {
            this.base = base;
            this.attrs = attrs;
        }
    }

    public static class Stable {
        public final Undefined origin;
        public final Set<Attribute.Stable> current;
        protected  Stable(Undefined origin, Set<Attribute.Stable> current) {

            this.origin = origin;
            this.current = current;
        }
    }
}
