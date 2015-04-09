package com.sim.star.bitworxx.starcity.cycle;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by WEIS on 09.04.2015.
 * GM stands for Game (GaMe)
 */
public class GM {

    public static GM_LoopTicker LT;
    public static GM_TimeFrame TF;

    public static Timer GeneralTimer;

    static {
        GeneralTimer = create_timer();
        LT = new GM_LoopTicker(5, 9);
        TF = new GM_TimeFrame();
    }

    public static Timer create_timer() {
        Timer result = new Timer("GM", true);
        result.schedule(new TimerTask() {
            @Override
            public void run() {
                Animate();
            }
        }, 1000);
        return result;
    }

    public static void Animate() {

        LoopEnum resultLT = LT.iterate();
        TimeEnum resultTF = TF.interate();
    }
}

