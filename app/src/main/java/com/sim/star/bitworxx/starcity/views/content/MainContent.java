package com.sim.star.bitworxx.starcity.views.content;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.constants.ContentFont;
import com.sim.star.bitworxx.starcity.constants.MenuConst;

import java.util.ArrayList;

/**
 * Created by WEIS on 15.04.2015.
 */
public class MainContent extends ContentWindow {

    private String S_HEADER_001 = "A) Main Menu Options";
    private String S_SUB_HEADER_001 = "1) Systems";
    private String S_CONTENT_001 = "1.1) Overview";
    private int Measure = MenuConst.FACTOR_TRIANGLE_OUT*2;
    private int MeasureL = MenuConst.MARGIN_CLIP_MINI;
    private int MeasureXL = MeasureL*MenuConst.FACTOR_TRIANGLE_OUT;
    private float YPos=0;
    public MainContent(Rect displayIn) {
        super(displayIn);
    }

    @Override
    protected void drawContents(Canvas canvas) {



        drawText(canvas, S_HEADER_001, 0,4, HeaderFontPaint);

        drawText(canvas, S_SUB_HEADER_001,8,6, SubHeaderFontPaint);

        drawText(canvas, S_CONTENT_001,4,10, FontPaint);


        drawRect(canvas,0,20,16,32);

        drawRect(canvas,7,14,8,16);

    }


    private void drawText(Canvas canvas,String text,int x,int y,Paint painter)
    {
        Point layoutPosition= getLayoutPosition(x,y);
        canvas.drawText(text,(float)layoutPosition.x,(float)layoutPosition.y,painter);

    }

    private void drawRect(Canvas canvas,int x,int y, int xx,int yy)
    {
        Paint p = new Paint();
        p.setColor(Color.argb(40,0,200,0));
        p.setStyle(Paint.Style.FILL);

        ArrayList<Point> rc = getLayoutPosition(x,y,xx,yy);

        canvas.drawRect(new Rect(rc.get(0).x,rc.get(0).y,rc.get(1).x,rc.get(1).y),p);
    }
}
