package com.sim.star.bitworxx.starcity.constants;

import android.graphics.Bitmap;

import com.sim.star.bitworxx.starcity.views.content.ContentWindow;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by WEIS on 14.04.2015.
 */
public class MenuBitmaps {

    public static Bitmap BITMAP_RACE;

    public static HashMap<UUID,Bitmap> BitmapDrawables = new HashMap<UUID,Bitmap>();

    public static ContentWindow ActualWindow=null;

    public static int PG()
    {
        if(ActualWindow!=null)
            return ActualWindow.getPagesCount();
        return 0;
    }
}
