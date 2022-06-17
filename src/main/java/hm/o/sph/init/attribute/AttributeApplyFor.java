package hm.o.sph.init.attribute;

import hm.o.sph.util.Tier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static hm.o.sph.util.Math.random;
import static java.lang.Math.max;
import static java.lang.Math.min;


public class AttributeApplyFor {
    private AttributeApplyFor() {
    }

    //region ATTRIBUTE

    @Contract(value = " -> new", pure = true)
    public static @NotNull Attribute creatingAttr() {
        return new Attribute();
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    public static Attribute.@NotNull Undefined creatingUndefAttr(Attribute attr, int fstBound, int secBound) {
        return new Attribute.Undefined(attr, min(fstBound, secBound), max(fstBound, secBound));
    }

    @Contract(value = "_ -> new", pure = true)
    public static Attribute.@NotNull Stable creatingStableAttr(@NotNull Attribute.Undefined attr) {
        return new Attribute.Stable(attr, random(attr.bound));
    }

    @Contract(value = "_ -> new", pure = true)
    public static Attribute.@NotNull Stable resettingStableAttr(Attribute.@NotNull Stable attr) {
        return new Attribute.Stable(attr.origin, random(attr.origin.bound));
    }

    //endregion
    //region IMPRINT

    @Contract(value = "_, _, _ -> new", pure = true)
    public static @NotNull Imprint creatingImp(ImprintSeries series, Tier tier, Set<Attribute> attrs) {
        return new Imprint(tier, series, attrs);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    public static @NotNull Imprint creatingImp(ImprintSeries series, Tier tier, Attribute attr) {
        return creatingImp(series, tier, Set.of(attr));
    }

    @Contract(value = "_, _, _, _ -> new", pure = true)
    public static @NotNull Imprint creatingImp(ImprintSeries series, Tier tier, Attribute attr1, Attribute attr2) {
        return creatingImp(series, tier, Set.of(attr1, attr2));
    }

    @Contract(value = "_, _, _, _, _ -> new", pure = true)
    public static @NotNull Imprint creatingImp(ImprintSeries series, Tier tier, Attribute attr1, Attribute attr2, Attribute attr3) {
        return creatingImp(series, tier, Set.of(attr1, attr2, attr3));
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull Imprint creatingUniqueImp(ImprintSeries series, Set<Attribute> attrs) {
        return creatingImp(series, Tier.TIERX, attrs);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static Imprint.@NotNull Undefined creatingUndefImp(Imprint base, Attribute.Undefined undefAttrs) {
        return new Imprint.Undefined(base, new HashSet<>(Collections.singletonList(undefAttrs)));
    }

    @Contract(value = "_ -> new", pure = true)
    public static Imprint.@NotNull Stable creatingStableImp(Imprint.Undefined undefImp) {
        return new Imprint.Stable(undefImp, undefImp.attrs.stream().map(AttributeApplyFor::creatingStableAttr).collect(Collectors.toSet()));
    }

    @Contract(value = "_ -> new", pure = true)
    public static Imprint.@NotNull Stable resettingImp(Imprint.@NotNull Stable stableImp) {
        return new Imprint.Stable(stableImp.origin, stableImp.current.stream().map(AttributeApplyFor::resettingStableAttr).collect(Collectors.toSet()));
    }

    @Contract(pure = true)
    public static boolean checkingUniqueImp(Imprint.@NotNull Undefined imp) {
        return imp.base.tier.equals(Tier.TIERX);
    }

    @Contract(pure = true)
    public static boolean checkingNormalImp(Imprint.@NotNull Undefined imp) {
        return !checkingUniqueImp(imp);
    }

    @Contract(pure = true)
    public static boolean checkingExtraordinary(Imprint.@NotNull Stable imp) {
        return imp.extraordinary;
    }

    @Contract("_, _ -> param1")
    public static Imprint.@NotNull Stable increasingExtraImp(Imprint.@NotNull Stable imp, Imprint.Stable extra1) {
        imp.extraImps.add(extra1);
        return imp;
    }

    @Contract("_, _, _ -> param1")
    public static Imprint.@NotNull Stable increasingExtraImp(Imprint.@NotNull Stable imp, Imprint.Stable extra1, Imprint.Stable extra2) {
        imp.extraImps.addAll(Set.of(extra1, extra2));
        return imp;
    }

    //endregion
    //region Imprint Series

    @Contract(value = "_, _, _ -> new", pure = true)
    public static @NotNull ImprintSeries creatingImpSeries(String id, Tier fstBound, Tier secBound) {
        return new ImprintSeries(id, fstBound, secBound);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull ImprintSeries creatingImpSeries(String id, Tier bound) {
        return creatingImpSeries(id, bound, bound);
    }

    //endregion
}
