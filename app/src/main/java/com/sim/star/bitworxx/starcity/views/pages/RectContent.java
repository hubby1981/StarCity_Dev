package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.content.ContentWindow;

import java.util.ArrayList;

/**
 * Created by WEIS on 17.04.2015.
 */
public abstract class RectContent extends Content  {
    public RectContent(CoPo p) {
        super(p);
    }

    @Override
    protected void onDrawInternal(Canvas canvas, Rect rect, ContentWindow window) {
        ArrayList<Rect> list = new ArrayList<>();
        list.add(rect);
        list.add(rect);
        onDrawInternal(canvas, list, window);
    }

}
