package com.sim.star.bitworxx.starcity.views;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.constants.MenuConst;

/**
 * Created by WEIS on 10.04.2015.
 */
public class Mini {


    public Rect DisplayRect = null;
    private Bitmap DisplayBitmap = null;


    public Bitmap getAsBitmap() {

        if (DisplayBitmap == null) {
            DisplayBitmap = Bitmap.createBitmap(DisplayRect.width(), DisplayRect.height(), Bitmap.Config.ARGB_4444);

            Canvas canvas = new Canvas(DisplayBitmap);
            Draw(canvas);
        }

        return DisplayBitmap;
    }

    public void HandleDisplay(int w, int h) {
        if (DisplayRect == null)
            DisplayRect = new Rect(0, 0, w, h);
    }

    private void Draw(Canvas canvas) {
        canvas.drawRect(DisplayRect, MenuConst.BACK_PAINTER);
    }

}