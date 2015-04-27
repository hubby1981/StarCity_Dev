package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.content.ContentWindow;

import java.util.ArrayList;

/**
 * Created by WEIS on 17.04.2015.
 */
public class LineContent extends RectContent  {
    public LineContent(CoPo p) {
        super(p);
    }


    @Override
    protected void onDrawInternal(Canvas canvas, ArrayList<Rect> rects, ContentWindow window) {

           Rect r = combineRects(rects.get(0),rects.get(1));

        if(rects.get(0).top==rects.get(1).top)
           canvas.drawLine(r.left,r.top,r.right,r.top, MenuConst.LINE_STROKE_BACK_PAINTER);
        else
            canvas.drawLine(r.left,r.top,r.left,r.bottom, MenuConst.LINE_STROKE_BACK_PAINTER);
    }
}
