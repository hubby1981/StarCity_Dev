package com.sim.star.bitworxx.starcity.game.enums;

import java.util.HashMap;

/**
 * Created by WEIS on 22.04.2015.
 */
public class GON {

    public static HashMap<String,Integer> GONS;
    static {
        GONS=new HashMap<>();


        GONS.put("game",1);
        GONS.put("ship",100);
        GONS.put("player",100);
        GONS.put("bank",100);
        GONS.put("universe",1);
        GONS.put("area",16);
        GONS.put("galaxy",256);
        GONS.put("galaxy-area",16);
        GONS.put("galaxy-field",16);
        GONS.put("galaxy-sector",16);
        GONS.put("galaxy-system",16);
        GONS.put("galaxy-system-object",-1);
        GONS.put("star",-1);
        GONS.put("planet",-1);
        GONS.put("moon",-1);
        GONS.put("station",-1);




    }
}
