package com.sim.star.bitworxx.starcity.db;

import java.util.Random;

/**
 * Created by WEIS on 22.04.2015.
 */
public final class RandomRange {


    private static int getRandom(int aStart, int aEnd){
        if (aStart > aEnd) {
            int aSave=aStart;
            aStart = aEnd;
            aEnd=aSave;
        }
        //get the range, casting to long to avoid overflow problems
        long range = (long)aEnd - (long)aStart + 1;
        // compute a fraction of the range, 0 <= frac < range
        long fraction = (long)(range * new Random().nextDouble());
       return  (int)(fraction + aStart);

    }

}