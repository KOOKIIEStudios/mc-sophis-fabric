package hm.o.sph.init.attribute;

import hm.o.sph.util.Tier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

import static hm.o.sph.util.Math.random;
import static java.lang.Math.max;
import static java.lang.Math.min;


public class AttributeApplyFor {
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
    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull Imprint creatingImprint(ImprintSeries series, Tier tier) {
        return new Imprint(tier, series);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static Imprint.@NotNull Undefined creatingUndefImprint(Imprint base, Attribute.Undefined undefAttrs) {
        return new Imprint.Undefined(base, new HashSet<>(Collections.singletonList(undefAttrs)));
    }

    @Contract(value = "_ -> new", pure = true)
    public static Imprint.@NotNull Stable creatingStableImprint(Imprint.Undefined undefImp) {
        return new Imprint.Stable(undefImp, undefImp.attrs.stream().map(AttributeApplyFor::creatingStableAttr).collect(Collectors.toSet()));
    }

    @Contract(value = "_ -> new", pure = true)
    public static Imprint.@NotNull Stable resettingImprint(Imprint.@NotNull Stable stableImp) {
        return new Imprint.Stable(stableImp.origin, stableImp.current.stream().map(AttributeApplyFor::resettingStableAttr).collect(Collectors.toSet()));
    }
    //endregion
}