package com.sim.star.bitworxx.starcity.views.anim;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.constants.MenuBitmaps;
import com.sim.star.bitworxx.starcity.views.Mini;

/**
 * Created by WEIS on 14.04.2015.
 */
public class BitmapAnimation extends Animateable {
    private Bitmap Display;

    public BitmapAnimation(Mini parent, Bitmap bitmap) {

        super(parent);
        Display = bitmap;

    }

    public void drawItems() {
        if (canDraw()) {

            if (Display != null) {

                Parent.getAsCanvas().drawBitmap(MenuBitmaps.BITMAP_RACE, new Rect(0, 0, Display.getWidth(), Display.getHeight()), DisplayRect, null);
            }
        }
    }
}
