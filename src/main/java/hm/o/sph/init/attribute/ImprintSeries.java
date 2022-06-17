package hm.o.sph.init.attribute;

import hm.o.sph.util.Tier;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;

public class ImprintSeries {
    public final String id;
    public final Pair<Tier, Tier> bounds;

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
}
