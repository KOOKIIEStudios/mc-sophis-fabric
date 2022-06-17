package hm.o.sph.util;

import org.apache.commons.lang3.tuple.Pair;

import java.util.concurrent.ThreadLocalRandom;

public class Math {
    public static int random(int min, int max) {
        if(min == max) return max;
        int minR = java.lang.Math.min(max, min);
        int maxR = java.lang.Math.max(max, min);
        return ThreadLocalRandom.current().nextInt(minR, maxR);
    }

    public static int random(Pair<Integer, Integer> tuple) {
        return random(tuple.getLeft(), tuple.getRight());
    }
}
