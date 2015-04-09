package com.sim.star.bitworxx.starcity.cycle;

/**
 * Created by WEIS on 09.04.2015.
 * GM stands for Game (GaMe)
 */
public class GM {

    public static GM_LoopTicker LT = new GM_LoopTicker(5, 9);
    public static GM_TimeFrame TF = new GM_TimeFrame();

    public static void Animate() {

        LoopEnum resultLT = LT.iterate();
        TimeEnum resultTF = TF.interate();
    }
}

