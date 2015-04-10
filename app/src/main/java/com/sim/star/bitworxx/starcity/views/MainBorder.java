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

/**
 * Created by WEIS on 09.04.2015.
 */

public class MainBorder extends View {


    public MainBorder(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private RectF getOutboundRectF() {
        return new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    private Rect getOutboundRect() {
        return new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    private Rect getInboundRect() {
        return new Rect(getOutboundRect().left + translateMarginWidth(), getOutboundRect().top + translateMarginHeight(),
                getOutboundRect().right - translateMarginWidth(), getOutboundRect().bottom - translateMarginHeight());
    }

    private RectF getInboundRectF() {
        return new RectF(getOutboundRect().left + translateMarginWidth(), getOutboundRect().top + translateMarginHeight(),
                getOutboundRect().right - translateMarginWidth(), getOutboundRect().bottom - translateMarginHeight());
    }

    private Path getInboundPath() {
        Path p = new Path();
        p.addRect(getInboundRectF(), Path.Direction.CW);
        return p;
    }

    private Path getEquilateralTriangle(Point p1, int factor, Direction direction) {
        Point p2 = null, p3 = null;

        if (direction == Direction.WEST) {
            p2 = new Point(p1.x + translateMarginWidth() / factor, p1.y);
            p3 = new Point(p1.x, p1.y + translateMarginWidth() / factor);

        } else if (direction == Direction.EAST) {
            p2 = new Point(p1.x - translateMarginWidth() / factor, p1.y);
            p3 = new Point(p1.x, p1.y + translateMarginWidth() / factor);

        } else if (direction == Direction.SOUTH) {
            p2 = new Point(p1.x - translateMarginWidth() / factor, p1.y);
            p3 = new Point(p1.x, p1.y - translateMarginWidth() / factor);

        } else if (direction == Direction.NORTH) {
            p2 = new Point(p1.x + translateMarginWidth() / factor, p1.y);
            p3 = new Point(p1.x, p1.y - translateMarginWidth() / factor);

        }

        Path path = new Path();
        path.moveTo(p1.x, p1.y);
        path.lineTo(p2.x, p2.y);
        path.lineTo(p3.x, p3.y);

        return path;
    }

    private int translateMarginWidth() {
        return (getMeasuredWidth() / 100) * MenuConst.MARGIN_CLIP;
    }

    private int translateMarginHeight() {
        return (getMeasuredHeight() / 100) * MenuConst.MARGIN_CLIP;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path p = new Path();
        p.addRect(getOutboundRectF(), Path.Direction.CW);

        canvas.clipPath(p);
        canvas.clipPath(getInboundPath(), Region.Op.DIFFERENCE);
        canvas.clipPath(getEquilateralTriangle(new Point(getOutboundRect().left, getOutboundRect().top), MenuConst.FAKTOR_TRIANLGE_OUT, Direction.WEST), Region.Op.DIFFERENCE);
        canvas.clipPath(getEquilateralTriangle(new Point(getInboundRect().left, getInboundRect().top), MenuConst.FAKTOR_TRIANLGE_IN, Direction.WEST), Region.Op.UNION);

        canvas.clipPath(getEquilateralTriangle(new Point(getOutboundRect().right, getOutboundRect().top), MenuConst.FAKTOR_TRIANLGE_OUT, Direction.EAST), Region.Op.DIFFERENCE);
        canvas.clipPath(getEquilateralTriangle(new Point(getInboundRect().right, getInboundRect().top), MenuConst.FAKTOR_TRIANLGE_IN, Direction.EAST), Region.Op.UNION);

        canvas.clipPath(getEquilateralTriangle(new Point(getOutboundRect().right, getOutboundRect().bottom), MenuConst.FAKTOR_TRIANLGE_OUT, Direction.SOUTH), Region.Op.DIFFERENCE);
        canvas.clipPath(getEquilateralTriangle(new Point(getInboundRect().right, getInboundRect().bottom), MenuConst.FAKTOR_TRIANLGE_IN, Direction.SOUTH), Region.Op.UNION);

        canvas.clipPath(getEquilateralTriangle(new Point(getOutboundRect().left, getOutboundRect().bottom), MenuConst.FAKTOR_TRIANLGE_OUT, Direction.NORTH), Region.Op.DIFFERENCE);
        canvas.clipPath(getEquilateralTriangle(new Point(getInboundRect().left, getInboundRect().bottom), MenuConst.FAKTOR_TRIANLGE_IN, Direction.NORTH), Region.Op.UNION);
        canvas.drawPath(p, MenuConst.BACK_PAINTER);


    }


}
