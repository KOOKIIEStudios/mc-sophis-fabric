package hm.o.sph.util;

import org.jetbrains.annotations.NotNull;

public enum SophisRarity {
    COMMON(0xffffff, "common"),
    RARE(0x8379d2, "rare"),
    DREAMY(0xd2cf79, "dreamy"),
    MYTH(0xd2aa79, "myth"),
    FANTASY(0x79d294, "fantasy"),
    EX_DREAMY(0xfff94d, "ex_dreamy"),
    EX_MYTH(0xffaf4d, "ex_myth"),
    EX_FANTASY(0x4dff82, "ex_fantasy");

    SophisRarity(int hex, String id) {
        this.hex = hex;
        this.id = id;
    }

    public final int hex;
    public final String id;

    public static @NotNull SophisRarity getById(String id) {
        for(var val : SophisRarity.values()) {
            if(val.id.equalsIgnoreCase(id)) {
                return val;
            }
        }
        throw new IllegalArgumentException("Wrong identifier to check Sophis Rarity.");
    }
}
