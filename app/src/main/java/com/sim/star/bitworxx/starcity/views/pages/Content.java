package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.views.content.ContentWindow;

import java.util.ArrayList;

/**
 * Created by WEIS on 16.04.2015.
 */
public abstract class Content {

    public Point LeftTop;
    public Point RightBottom;

    public Content(Point leftTop)
    {
        this(leftTop,leftTop);
    }

    public Content(Point leftTop,Point rightBottom)
    {
        LeftTop=leftTop;
        RightBottom=rightBottom;
    }

    public boolean isSinglePoint()
    {
        return LeftTop.x==RightBottom.x && LeftTop.y==RightBottom.y;
    }

    public void onDraw(Canvas canvas,ContentWindow window)
    {
        if(isSinglePoint())
            onDrawInternal(canvas,window.getLayoutPosition(LeftTop.x,LeftTop.y),window);
        else
            onDrawInternal(canvas, window.getLayoutPosition(LeftTop.x, LeftTop.y, RightBottom.x, RightBottom.y), window);
    }

    protected abstract void onDrawInternal(Canvas canvas,Rect rect,ContentWindow window);
    protected abstract void onDrawInternal(Canvas canvas,ArrayList<Rect> rects,ContentWindow window);


}
