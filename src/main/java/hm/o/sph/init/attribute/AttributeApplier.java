package hm.o.sph.init.attribute;

import hm.o.sph.util.Tier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static hm.o.sph.util.Math.random;
import static java.lang.Math.max;
import static java.lang.Math.min;


public class AttributeApplier {
    private AttributeApplier() {
    }

    //region ATTRIBUTE

    @Contract(value = " -> new", pure = true)
    public static @NotNull Attribute createAttr() {
        return new Attribute();
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    public static Attribute.@NotNull Undefined createUndefAttr(Attribute attr, int fstBound, int secBound) {
        return new Attribute.Undefined(attr, min(fstBound, secBound), max(fstBound, secBound));
    }

    @Contract(value = "_ -> new", pure = true)
    public static Attribute.@NotNull Stable createStableAttr(@NotNull Attribute.Undefined attr) {
        return new Attribute.Stable(attr, random(attr.bound));
    }

    @Contract(value = "_ -> new", pure = true)
    public static Attribute.@NotNull Stable resetStableAttr(Attribute.@NotNull Stable attr) {
        return new Attribute.Stable(attr.origin, random(attr.origin.bound));
    }

    //endregion
    //region IMPRINT

    @Contract(value = "_, _, _ -> new", pure = true)
    public static @NotNull Imprint createImp(ImprintSeries series, Tier tier, Set<Attribute> attrs) {
        return new Imprint(tier, series, attrs);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    public static @NotNull Imprint createImp(ImprintSeries series, Tier tier, Attribute attr) {
        return createImp(series, tier, Set.of(attr));
    }

    @Contract(value = "_, _, _, _ -> new", pure = true)
    public static @NotNull Imprint createImp(ImprintSeries series, Tier tier, Attribute attr1, Attribute attr2) {
        return createImp(series, tier, Set.of(attr1, attr2));
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull Imprint createUniqueImp(ImprintSeries series, Set<Attribute> attrs) {
        return createImp(series, Tier.TIERX, attrs);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static Imprint.@NotNull Undefined createUndefImp(Imprint base, Attribute.Undefined undefAttrs) {
        return new Imprint.Undefined(base, new HashSet<>(Collections.singletonList(undefAttrs)));
    }

    @Contract(value = "_ -> new", pure = true)
    public static Imprint.@NotNull Stable createStableImp(Imprint.Undefined undefImp) {
        return new Imprint.Stable(undefImp, undefImp.attrs.stream().map(AttributeApplier::createStableAttr).collect(Collectors.toSet()));
    }

    @Contract(value = "_ -> new", pure = true)
    public static Imprint.@NotNull Stable resetImp(Imprint.@NotNull Stable stableImp) {
        return new Imprint.Stable(stableImp.origin, stableImp.current.stream().map(AttributeApplier::resetStableAttr).collect(Collectors.toSet()));
    }

    @Contract(pure = true)
    public static boolean checkUniqueImp(Imprint.@NotNull Undefined imp) {
        return imp.base.tier.equals(Tier.TIERX);
    }

    @Contract(pure = true)
    public static boolean checkNormalImp(Imprint.@NotNull Undefined imp) {
        return !checkUniqueImp(imp);
    }

    @Contract(pure = true)
    public static boolean checkExtraordinaryImp(Imprint.@NotNull Stable imp) {
        return imp.extraordinary;
    }

    @Contract("_, _ -> param1")
    public static Imprint.@NotNull Stable increaseExtraImp(Imprint.@NotNull Stable imp, Imprint.Stable extra1) {
        imp.extraImps.add(extra1);
        return imp;
    }

    @Contract("_, _, _ -> param1")
    public static Imprint.@NotNull Stable increaseExtraImp(Imprint.@NotNull Stable imp, Imprint.Stable extra1, Imprint.Stable extra2) {
        imp.extraImps.addAll(Set.of(extra1, extra2));
        return imp;
    }

    //endregion
    //region Imprint Series

    @Contract(value = "_, _, _ -> new", pure = true)
    public static @NotNull ImprintSeries createImpSeries(String id, Tier fstBound, Tier secBound) {
        return new ImprintSeries(id, fstBound, secBound);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull ImprintSeries createImpSeries(String id, Tier bound) {
        return createImpSeries(id, bound, bound);
    }

    //endregion
}