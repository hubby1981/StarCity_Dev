package com.sim.star.bitworxx.starcity.cycle;

import com.sim.star.bitworxx.starcity.MainScreen;
import com.sim.star.bitworxx.starcity.constants.MenuBitmaps;
import com.sim.star.bitworxx.starcity.game.enums.LoopEnum;
import com.sim.star.bitworxx.starcity.game.enums.RaceEnum;
import com.sim.star.bitworxx.starcity.game.enums.TimeEnum;
import com.sim.star.bitworxx.starcity.player.PlayerBag;

import java.util.Date;
import java.util.Locale;

/**
 * Created by WEIS on 09.04.2015.
 * GM stands for Game (GaMe)
 */
public class GM {

    public static GM_LoopTicker LT;
    public static GM_TimeFrame TF;
    public static String Started;
    public static PlayerBag Player;
    public static String LOCALE = "en-";
    public static String LOCALE_A = Locale.getDefault().getLanguage()+"-";
    public static long TS=0;
    public static long TE =0;
    public static long DEGREE = 0;

    public static String SYSTEM_NAME="pytico II";
    static {

        LT = new GM_LoopTicker(5, 9);
        TF = new GM_TimeFrame();
        Player = new PlayerBag().create_bag("MustSet", RaceEnum.MustSelect);
        Started = new Date().toString();
    }


    public static void animate() {

        LoopEnum resultLT = LT.iterate();
        TimeEnum resultTF = TF.interate();
        DEGREE+=30;
        if(DEGREE>360)DEGREE=0;

        if(resultLT==LoopEnum.NEXT_LOOP)
            MainScreen.Loop.run();
    }


}

