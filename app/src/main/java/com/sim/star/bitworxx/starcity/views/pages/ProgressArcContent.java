package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;

import com.sim.star.bitworxx.starcity.constants.ColorSetter;
import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.content.ContentWindow;

import java.util.ArrayList;

/**
 * Created by WEIS on 30.04.2015.
 */
public class ProgressArcContent extends ProgressBarContent {
    public ProgressArcContent(CoPo p) {
        super(p);
    }



    @Override
    protected void drawFilling(Canvas canvas,Rect r, ContentWindow window)
    {
        Bitmap rb = Bitmap.createBitmap(r.width(),r.height(), Bitmap.Config.ARGB_4444);

        Rect ro = r;
        r=new Rect(0,0,0+r.width(),0+r.height());
        Canvas canvas2 = new Canvas(rb);

        RectF rf1 = new RectF((float)r.left,(float)r.top,(float)r.right,(float)r.bottom);
        int w = r.width()/4;
        int h =r.height()/4;
        RectF rf2 = new RectF((float)r.left+w,(float)r.top+h,(float)r.right-w,(float)r.bottom-h);
        RectF rf3 = new RectF((float)r.left+w/2,(float)r.top+h/2,(float)r.right-w/2,(float)r.bottom-h/2);
        Paint p = new Paint();
        p.setStrokeWidth(w-2);
        p.setColor(ColorSetter.FILL_BACK_COLOR_PLATE);
        p.setStyle(Paint.Style.STROKE);
        p.setAntiAlias(true);
        int rate=90;
        Path p1 = new Path();
        p1.addArc(rf2,0,360);
        canvas2.clipPath(p1, Region.Op.DIFFERENCE);
        canvas2.drawArc(rf1,0,360,true, MenuConst.BACK_PAINTER_CONTENT_INNER);

        canvas2.drawArc(rf3,0,generateRatio(360),true, p);
        canvas2.drawArc(rf3,0,generateRatio(360),true, MenuConst.BACK_PAINTER_CONTENT_INNER2);

        canvas2.drawArc(rf2,0,360,true, MenuConst.STROKE_BACK_PAINTER);
        canvas2.drawArc(rf1,0,360,true, MenuConst.STROKE_BACK_PAINTER);

        canvas.drawBitmap(rb,ro.left,ro.top,null);

        Paint font = window.FontPaint;
        String t=((Integer)Progress).toString();
        int mf = (int)font.measureText(t);

        canvas.drawText(t,ro.centerX()-mf/2,ro.centerY()+(font.getTextSize()/2),font);
    }
}