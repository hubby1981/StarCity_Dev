package com.sim.star.bitworxx.starcity.views.touch;

import android.graphics.Point;

import java.util.ArrayList;

/**
 * Created by WEIS on 14.04.2015.
 */
public class ActionContainer {

    public static ArrayList<ActionHandler> Handler;
    public static boolean InitBorder = false;

    static {
        Handler = new ArrayList<ActionHandler>();
    }

    public static void checkUp(Point point) {
        if (Handler != null)
            for (ActionHandler h : Handler) {
                h.checkUp(point);
            }
    }
}
