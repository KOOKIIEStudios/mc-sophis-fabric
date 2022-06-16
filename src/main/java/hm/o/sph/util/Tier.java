package hm.o.sph.util;

public enum Tier {

    TIER1("t1", 1),
    TIER2("t2", 2),
    TIER3("t3", 3),
    TIER4("t4", 4),
    TIER5("t5", 5),
    TIERX("tx", 0);

    Tier(String id, int level) {
        this.id = id;
        this.level = level;
    }

    public final String id;
    public final int level;
}
