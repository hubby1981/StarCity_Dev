package com.sim.star.bitworxx.starcity.views;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.MainScreen;
import com.sim.star.bitworxx.starcity.constants.MenuBitmaps;
import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.display.Show;
import com.sim.star.bitworxx.starcity.geometric.GeometricHelp;

import java.util.UUID;

/**
 * Created by WEIS on 10.04.2015.
 */
public class Mini {


    public Rect DisplayRect = null;
    public Rect InboundRect = null;
    public Runnable Action;
    public Point Measure;

    public UUID Id;

    public Mini()
    {
        Id=UUID.randomUUID();
    }

    public Bitmap getAsBitmap() {

        if (!MenuBitmaps.BitmapDrawables.containsKey(Id)) {
            MenuBitmaps.BitmapDrawables.put(Id, Bitmap.createBitmap(DisplayRect.width(), DisplayRect.height(), Bitmap.Config.ARGB_4444));

            Canvas canvas = new Canvas(MenuBitmaps.BitmapDrawables.get(Id));
            Draw(canvas);
        }

        return MenuBitmaps.BitmapDrawables.get(Id);
    }

    public Canvas getAsCanvas() {
        return new Canvas(getAsBitmap());
    }

    public void setRunnable(Runnable action) {
        Action = action;
    }

    public void HandleDisplay(int w, int h) {
        if (DisplayRect == null)
            DisplayRect = new Rect(0, 0, w, h);
    }



    public void checkUp(Point check) {
        if (InboundRect != null) {
            Rect checkR = new Rect(Measure.x, Measure.y, Measure.x + DisplayRect.width(), Measure.y + DisplayRect.height());
            if (checkR.contains(check.x, check.y)) {
                if (Action != null) {

                    Action.run();

                }
            }
        }
    }


    public Rect getInboundRect(int w) {
        InboundRect = new Rect(DisplayRect.left + w, DisplayRect.top + w, DisplayRect.right - w, DisplayRect.bottom - w);
        return InboundRect;
    }

    private void makePlateH(Canvas canvas, int x, int y, int w, int h, boolean invert) {
        Path plate = new Path();


        x += translateMarginWidth() * MenuConst.FACTOR_TRIANGLE_OUT;
        w -= translateMarginWidth() * MenuConst.FACTOR_TRIANGLE_OUT;


        Point p1 = new Point(x, y);
        Point p2 = new Point(w, y);

        Point p3 = new Point(w - translateMarginWidth(), h - ((h - y) / 2));
        Point p4 = new Point(x + translateMarginWidth(), h - ((h - y) / 2));

        plate.moveTo(p1.x, p1.y);
        plate.lineTo(p2.x, p2.y);
        plate.lineTo(p3.x, p3.y);
        plate.lineTo(p4.x, p4.y);
        plate.lineTo(p1.x, p1.y);

        canvas.drawPath(plate, MenuConst.PLATE_BACK_PAINTER);
        canvas.drawPath(plate, MenuConst.PLATE_STROKE_BACK_PAINTER);
    }

    private void makePlateV(Canvas canvas, int x, int y, int w, int h, boolean invert) {
        Path plate = new Path();


        y += translateMarginHeight() * MenuConst.FACTOR_TRIANGLE_OUT;
        h -= translateMarginHeight() * MenuConst.FACTOR_TRIANGLE_OUT;


        w -= (w - x) / 2;
        Point p1 = new Point(x, y);

        Point p4 = new Point(x, h);


        Point p2 = new Point(w, y + translateMarginHeight());
        Point p3 = new Point(w, h - translateMarginHeight());


        plate.moveTo(p1.x, p1.y);
        plate.lineTo(p2.x, p2.y);
        plate.lineTo(p3.x, p3.y);
        plate.lineTo(p4.x, p4.y);
        plate.lineTo(p1.x, p1.y);

        canvas.drawPath(plate, MenuConst.PLATE_BACK_PAINTER);
        canvas.drawPath(plate, MenuConst.PLATE_STROKE_BACK_PAINTER);
    }

    public int translateMarginHeight() {
        return (DisplayRect.height() / 100) * MenuConst.MARGIN_CLIP_MINI;
    }

    public int translateMarginWidth() {
        return (DisplayRect.height() / 100) * MenuConst.MARGIN_CLIP_MINI;
    }

    private void Draw(Canvas canvas) {


        int w = translateMarginWidth();
        int h = translateMarginHeight();


        Path outerPath = GeometricHelp.generateTrianglePath(DisplayRect, w, h);
        Path innerPath = GeometricHelp.generateTrianglePath(getInboundRect(w + w), w, h);

        if(Show.RenderMenuShader)
            canvas.drawPath(outerPath, MenuConst.BACK_PAINTER_WITH_SHADER);

        canvas.drawPath(outerPath, MenuConst.BACK_PAINTER);


        canvas.drawPath(innerPath, MenuConst.FORE_PAINTER);
        canvas.drawPath(innerPath, MenuConst.STROKE_FORE_PAINTER);
        canvas.drawPath(outerPath, MenuConst.STROKE_FORE_PAINTER);
        makePlateH(canvas, getOutboundRect().left, getOutboundRect().top, getOutboundRect().right, getInboundRect(w + w).top, true);

        makePlateH(canvas, getOutboundRect().left, getOutboundRect().bottom, getOutboundRect().right, getInboundRect(w + w).bottom, false);

        makePlateV(canvas, getOutboundRect().left, getOutboundRect().top, getInboundRect(w + w).left, getOutboundRect().bottom, true);
        makePlateV(canvas, getOutboundRect().right, getOutboundRect().top, getInboundRect(w + w).right, getOutboundRect().bottom, false);

    }

    public Rect getOutboundRect() {
        return DisplayRect;
    }
}