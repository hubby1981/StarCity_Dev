package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.content.ContentWindow;

import java.util.ArrayList;

/**
 * Created by WEIS on 30.04.2015.
 */
public class ProgressBarContent extends ProgressContent {
    public ProgressBarContent(CoPo p) {
        super(p);
    }

    @Override
    public int generateRatio(int width) {
        return (width/100)*Progress;
    }

    @Override
    protected void onDrawInternal(Canvas canvas, ArrayList<Rect> rects, ContentWindow window) {

        if(rects.size()>=2) {
            Rect r = combineRects(rects.get(0), rects.get(1));
        r=scaleRect(r);

            drawFilling(canvas,r,window);

        }
    }

    protected void drawFilling(Canvas canvas,Rect r, ContentWindow window)
    {
       // Rect fill = new Rect(r.left+1,r.top+1,r.left+generateRatio(r.width()),r.bottom);


        r=scaleRect(r);
        int w=r.width()/10;
        int l=r.left;
        int max=generateRatio(100)/10;
        for(int i=0;i<10;i++)
        {



            Rect fill = new Rect(l,r.top,l+w,r.bottom);
            Rect fill2 = new Rect(l+4,r.top+4,(l+w)-4,(r.bottom)-4);

            if(i<max) {
                canvas.drawRect(fill, MenuConst.PLATE_BACK_PAINTER);
            }else
            {
                canvas.drawRect(fill, MenuConst.BACK_PAINTER_CONTENT_INNER2);

            }
            l+=w;
            canvas.drawRect(fill2, MenuConst.BACK_PAINTER_CONTENT_INNER2);
            canvas.drawRect(fill,MenuConst.STROKE_BACK_PAINTER);
        }

        Paint font = window.FontPaint;
        String t=((Integer)Progress).toString();
        int mf = (int)font.measureText(t);

        canvas.drawText(t,r.centerX()-mf/2,r.centerY()+(font.getTextSize()/2),font);


    }
}
