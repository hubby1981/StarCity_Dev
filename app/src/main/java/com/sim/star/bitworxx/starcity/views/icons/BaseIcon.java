package com.sim.star.bitworxx.starcity.views.icons;

import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;

import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.geometric.MSize;

/**
 * Created by WEIS on 13.04.2015.
 */
public abstract class BaseIcon {

    protected Point Position;

    protected MSize Size;
    protected MSize SizeV;

    protected Point Middle;

    public abstract Path getPath(Rect displayIn);


    protected void generatePoints(Rect displayIn) {
        Position = new Point(displayIn.left, displayIn.top);
        Size = new MSize(displayIn.width() / MenuConst.FACTOR_TRIANGLE_OUT, displayIn.height() / MenuConst.MARGIN_CLIP_MINI);
        SizeV = new MSize(displayIn.width() / MenuConst.MARGIN_CLIP_MINI, displayIn.height() / MenuConst.FACTOR_TRIANGLE_OUT);
        Middle = new Point(displayIn.right - displayIn.width() / 2, displayIn.bottom - displayIn.height() / 2);
    }

    public static RectF makeRectF(int l,int t,int r,int b)
    {
        return new RectF((float)l,(float)t,(float)r,(float)b);
    }
}
