package hm.o.sph.init.attribute;

import hm.o.sph.SophisRegistries;
import hm.o.sph.util.Tier;
import net.minecraft.util.registry.RegistryEntry;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Imprint {

    protected final RegistryEntry.Reference<Imprint> regEntry;

    protected Imprint(Tier tier, ImprintSeries series) {
        regEntry = SophisRegistries.IMPRINT.createEntry(this);
        this.tier = tier;
        this.series = series;
    }

    public final Tier tier;
    public final ImprintSeries series;

    @Contract(value = " _, _-> new", pure = true)
    public static @NotNull Imprint with(ImprintSeries series, Tier tier) {
        return new Imprint(tier, series);
    }

    public static class Undefined {

        protected Undefined(Imprint base, Set<Attribute.Undefined> attrs) {
            this.base = base;
            this.attrs = attrs;
        }

        public final Imprint base;
        public final Set<Attribute.Undefined> attrs;

        public static @NotNull Undefined of(Imprint base, Attribute.Undefined... attrs) {
            var b = new Undefined(base, new HashSet<>());
            b.attrs.addAll(List.of(attrs));
            return b;
        }

        @Contract(value = "_ -> new", pure = true)
        public static @NotNull Stable toStable(Undefined undefinedImprint) {
            return Stable.of(undefinedImprint);
        }
    }

    public static class Stable {

        protected  Stable(Undefined origin, Set<Attribute.Stable> current) {

            this.origin = origin;
            this.current = current;
        }

        public final Undefined origin;
        public final Set<Attribute.Stable> current;

        @Contract(value = "_ -> new", pure = true)
        public static @NotNull Stable of(@NotNull Undefined undefinedAttr) {
            return new Stable(undefinedAttr, undefinedAttr.attrs.stream().map(Attribute.Undefined::toStable).collect(Collectors.toSet()));
        }

        @Contract(value = "_ -> new", pure = true)
        public static @NotNull Stable reset(@NotNull Stable stableImprint) {
            return new Stable(stableImprint.origin, stableImprint.current.stream().map(Attribute.Stable::reset).collect(Collectors.toSet()));
        }
    }
}
