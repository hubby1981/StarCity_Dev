package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.content.ContentWindow;

import java.util.ArrayList;

/**
 * Created by WEIS on 30.04.2015.
 */
public  abstract class ProgressContent extends RectContent {
    protected int Progress=35;
    protected int Step=10;
    protected int Min=0;

    protected int ScaleX = 1;
    protected int ScaleY=1;

    public ProgressContent(CoPo p) {
        super(p);
    }

    public abstract int generateRatio(int width);

    public void Reset()
    {
        Progress=Min;
    }

    protected Rect scaleRect(Rect r)
    {
        return new Rect(r.left,r.top,r.left+(r.width()/ScaleX),r.top+(r.height()/ScaleY));
    }

    public void doProgress()
    {
        Progress+=Step;
        if(Progress>100)
            Progress=Min;
    }
}
