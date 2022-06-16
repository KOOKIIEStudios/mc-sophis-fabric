package hm.o.sph.init.attribute;

import hm.o.sph.util.Tier;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;

public enum ImprintSeries {

    STARTER("starter", Tier.TIER1, Tier.TIER5);

    ImprintSeries(String id, @NotNull Tier firstBounds, Tier secondBounds) {
        this.id = id;
        if(firstBounds.equals(Tier.TIERX) || secondBounds.equals(Tier.TIERX)) throw new IllegalArgumentException("Wrong tier argument in declaration of ImprintSeries.");
        var minT = firstBounds.level < secondBounds.level ? firstBounds : secondBounds;
        var maxT = firstBounds.level < secondBounds.level ? secondBounds : firstBounds;
        this.bounds = Pair.of(minT, maxT);
    }

    public final String id;
    public final Pair<Tier, Tier> bounds;
}
