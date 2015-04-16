package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.content.ContentWindow;

import java.util.ArrayList;

/**
 * Created by WEIS on 16.04.2015.
 */
public abstract class Content {

 private CoPo P;

    public Content(Point leftTop)
    {
        this(leftTop,leftTop);
    }

    public Content(Point leftTop,Point rightBottom)
    {
       this(new CoPo(leftTop.x,leftTop.y,rightBottom.x,rightBottom.y));
    }

    public Content(CoPo p)
    {
        P=p;
    }

    public boolean isSinglePoint()
    {
        return P.isSingle();
    }

    public void onDraw(Canvas canvas,ContentWindow window)
    {
        if(isSinglePoint())
            onDrawInternal(canvas,window.getLayoutPosition(P.L,P.T),window);
        else
            onDrawInternal(canvas, window.getLayoutPosition(P.L,P.T,P.R,P.B), window);
    }

    protected abstract void onDrawInternal(Canvas canvas,Rect rect,ContentWindow window);
    protected abstract void onDrawInternal(Canvas canvas,ArrayList<Rect> rects,ContentWindow window);


}
