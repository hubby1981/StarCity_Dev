package com.sim.star.bitworxx.starcity.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;

import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.game.enums.Direction;
import com.sim.star.bitworxx.starcity.game.enums.MenuTriangle;
import com.sim.star.bitworxx.starcity.geometric.TriagleHelper;

/**
 * Created by WEIS on 09.04.2015.
 */

public class MainBorder extends View {


    private int MARGIN_CLIP;
    private MenuTriangle TRIANGLES = MenuTriangle.NONE;
    private Rect OutboundRect = null;
    private RectF OutboundRectF = null;

    private Rect InboundRect = null;
    private RectF InboundRectF = null;



    public MainBorder(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void init(int marginClip, MenuTriangle triangles) {
        MARGIN_CLIP = marginClip;
        TRIANGLES = triangles;
        refresh();
    }

    public void refresh() {
        OutboundRect = InboundRect = null;
        OutboundRectF = InboundRectF = null;
    }

    private RectF getOutboundRectF() {
        if (OutboundRect == null)
            OutboundRectF = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());
        return OutboundRectF;
    }

    private Rect getOutboundRect() {
        if (OutboundRect == null)
            OutboundRect = new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight());
        return OutboundRect;
    }

    private Rect getInboundRect() {
        if (InboundRect == null)
            InboundRect = new Rect(getOutboundRect().left + translateMarginWidth(), getOutboundRect().top + translateMarginHeight(),
                getOutboundRect().right - translateMarginWidth(), getOutboundRect().bottom - translateMarginHeight());
        return InboundRect;
    }

    private RectF getInboundRectF() {
        if (InboundRectF == null)
            InboundRectF = new RectF(getOutboundRect().left + translateMarginWidth(), getOutboundRect().top + translateMarginHeight(),
                getOutboundRect().right - translateMarginWidth(), getOutboundRect().bottom - translateMarginHeight());
        return InboundRectF;
    }

    private Path getInboundPath() {
        Path p = new Path();
        p.addRect(getInboundRectF(), Path.Direction.CW);
        return p;
    }



    private int translateMarginWidth() {
        return (getMeasuredWidth() / 100) * MARGIN_CLIP;
    }

    private int translateMarginHeight() {
        return (getMeasuredHeight() / 100) * MARGIN_CLIP;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path outboundPath = new Path();
        outboundPath.addRect(getOutboundRectF(), Path.Direction.CW);

        Path inboundPath = new Path();
        inboundPath.addRect(getInboundRectF(), Path.Direction.CW);

        canvas.clipPath(outboundPath);
        canvas.clipPath(inboundPath, Region.Op.DIFFERENCE);

        canvas.clipPath(TriagleHelper.getTriangle(new Point(getOutboundRect().left, getOutboundRect().top), MenuConst.FAKTOR_TRIANLGE_OUT, translateMarginWidth(), Direction.WEST), Region.Op.DIFFERENCE);
        canvas.clipPath(TriagleHelper.getTriangle(new Point(getInboundRect().left, getInboundRect().top), MenuConst.FAKTOR_TRIANLGE_IN, translateMarginWidth(), Direction.WEST), Region.Op.UNION);

        canvas.clipPath(TriagleHelper.getTriangle(new Point(getOutboundRect().right, getOutboundRect().top), MenuConst.FAKTOR_TRIANLGE_OUT, translateMarginWidth(), Direction.EAST), Region.Op.DIFFERENCE);
        canvas.clipPath(TriagleHelper.getTriangle(new Point(getInboundRect().right, getInboundRect().top), MenuConst.FAKTOR_TRIANLGE_IN, translateMarginWidth(), Direction.EAST), Region.Op.UNION);

        canvas.clipPath(TriagleHelper.getTriangle(new Point(getOutboundRect().right, getOutboundRect().bottom), MenuConst.FAKTOR_TRIANLGE_OUT, translateMarginWidth(), Direction.SOUTH), Region.Op.DIFFERENCE);
        canvas.clipPath(TriagleHelper.getTriangle(new Point(getInboundRect().right, getInboundRect().bottom), MenuConst.FAKTOR_TRIANLGE_IN, translateMarginWidth(), Direction.SOUTH), Region.Op.UNION);

        canvas.clipPath(TriagleHelper.getTriangle(new Point(getOutboundRect().left, getOutboundRect().bottom), MenuConst.FAKTOR_TRIANLGE_OUT, translateMarginWidth(), Direction.NORTH), Region.Op.DIFFERENCE);
        canvas.clipPath(TriagleHelper.getTriangle(new Point(getInboundRect().left, getInboundRect().bottom), MenuConst.FAKTOR_TRIANLGE_IN, translateMarginWidth(), Direction.NORTH), Region.Op.UNION);

        canvas.drawPath(outboundPath, MenuConst.BACK_PAINTER);


    }


}
