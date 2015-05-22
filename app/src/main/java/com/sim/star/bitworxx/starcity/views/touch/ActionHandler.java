package com.sim.star.bitworxx.starcity.views.touch;

import android.graphics.Point;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.MainScreen;

/**
 * Created by WEIS on 14.04.2015.
 */
public class ActionHandler {
    public Runnable Action;
    public Rect Bound;
    public String WindowToken;
    public String ContentToken;

    public ActionHandler(Rect bound, Runnable action,String contentToken) {
        Action = action;
        Bound = bound;

        ContentToken = contentToken;
    }

    public void checkUp(Point check) {
        if (Bound != null) {
            if (Bound.contains(check.x, check.y)) {
                if (Action != null ) {

                    Action.run();

                }
            }
        }
    }
}
