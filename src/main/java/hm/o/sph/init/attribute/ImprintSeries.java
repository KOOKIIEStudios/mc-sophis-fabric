package hm.o.sph.init.attribute;

import hm.o.sph.util.Tier;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class ImprintSeries {

    protected ImprintSeries(String id, @NotNull Tier firstBound, @NotNull Tier secondBound) {
        this.id = id;
        if(firstBound.equals(Tier.TIERX) || secondBound.equals(Tier.TIERX)) throw new IllegalArgumentException("Wrong tier argument in declaration of ImprintSeries.");
        if(firstBound.equals(secondBound)) {
            this.bounds = Pair.of(firstBound, firstBound);
        } else {
            var minT = firstBound.level < secondBound.level ? firstBound : secondBound;
            var maxT = firstBound.level < secondBound.level ? secondBound : firstBound;
            this.bounds = Pair.of(minT, maxT);
        }
    }

    public final String id;
    public final Pair<Tier, Tier> bounds;

    @Contract(value = "_, _, _ -> new", pure = true)
    public static @NotNull ImprintSeries apply(String id, Tier firstBound, Tier secondBound) {
        return new ImprintSeries(id, firstBound, secondBound);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull ImprintSeries apply(String id, Tier bound) {
        return apply(id, bound, bound);
    }

}
