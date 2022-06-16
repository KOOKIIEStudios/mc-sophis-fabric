package hm.o.sph.util;

import java.util.concurrent.ThreadLocalRandom;

public class Math {
    public static int random(int min, int max) {
        if(min == max) return max;
        int minR = java.lang.Math.min(max, min);
        int maxR = java.lang.Math.max(max, min);
        return ThreadLocalRandom.current().nextInt(minR, maxR);
    }
}
