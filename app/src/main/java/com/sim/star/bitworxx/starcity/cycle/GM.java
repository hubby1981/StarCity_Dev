package com.sim.star.bitworxx.starcity.cycle;

import com.sim.star.bitworxx.starcity.game.enums.LoopEnum;
import com.sim.star.bitworxx.starcity.game.enums.RaceEnum;
import com.sim.star.bitworxx.starcity.game.enums.TimeEnum;
import com.sim.star.bitworxx.starcity.player.PlayerBag;

import java.util.Date;

/**
 * Created by WEIS on 09.04.2015.
 * GM stands for Game (GaMe)
 */
public class GM {

    public static GM_LoopTicker LT;
    public static GM_TimeFrame TF;
    public static String Started;
    public static PlayerBag Player;

    public static long TS=0;
public static long TE =0;
    static {

        LT = new GM_LoopTicker(5, 9);
        TF = new GM_TimeFrame();
        Player = new PlayerBag().create_bag("MustSet", RaceEnum.MustSelect);
        Started = new Date().toString();
    }


    public static void animate() {

        LoopEnum resultLT = LT.iterate();
        TimeEnum resultTF = TF.interate();

    }


}

