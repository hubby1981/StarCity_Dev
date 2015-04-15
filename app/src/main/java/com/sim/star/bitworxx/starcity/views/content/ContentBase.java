package com.sim.star.bitworxx.starcity.views.content;

import android.graphics.Bitmap;
import android.graphics.Rect;

/**
 * Created by WEIS on 15.04.2015.
 */
public abstract class ContentBase {

    public Rect DisplayRect;
    public ContentBase(Rect displayIn)
    {
        DisplayRect=displayIn;
    }

    public abstract Bitmap draw();

    protected Bitmap generateBitmap()
    {
        return  Bitmap.createBitmap(DisplayRect.width(), DisplayRect.height(), Bitmap.Config.ARGB_4444);
    }
}
