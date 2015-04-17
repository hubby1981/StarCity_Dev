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

    protected ArrayList<Content> Childs;

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
        Childs=new ArrayList<>();
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

        for(Content c : Childs)
            c.onDraw(canvas,window);
    }

    protected Rect combineRects(Rect r1,Rect r2)
    {
        return new Rect(r1.left,r1.top,r2.right,r2.bottom);
    }

    protected Rect makeInnerRectWithTitle(Rect r,int pW,int h)
    {
        return new Rect(r.left + pW,r.top + h, r.right - pW, r.bottom - pW);
    }

    protected abstract void onDrawInternal(Canvas canvas,Rect rect,ContentWindow window);
    protected abstract void onDrawInternal(Canvas canvas,ArrayList<Rect> rects,ContentWindow window);


}
