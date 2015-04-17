package com.sim.star.bitworxx.starcity.views.touch;

import android.graphics.Point;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.constants.CliprRects;

import java.util.ArrayList;

/**
 * Created by WEIS on 14.04.2015.
 */
public class ActionContainer {

    public static ArrayList<ActionHandler> Handler;
    public static ArrayList<ActionHandler> HandlerButton;

    public static boolean InitBorder = false;

    static {
        Handler = new ArrayList<>();
        HandlerButton=new ArrayList<>();
    }

    public static void checkUp(Point point) {
        if (Handler != null)
            for (ActionHandler h : Handler) {
                h.checkUp(point);
            }
        if(HandlerButton!=null) {
            for (ActionHandler h : HandlerButton) {
                h.checkUp(point);
            }
        }
    }

    public static void flush()
    {
        if(HandlerButton!=null)
            HandlerButton.clear();
    }


    public static void addButton(Rect rect,Runnable action)
    {
        if(HandlerButton!=null)
            HandlerButton.add(new ActionHandler(rect,action));
    }
}
