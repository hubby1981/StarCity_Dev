package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.geometric.GeometricHelp;
import com.sim.star.bitworxx.starcity.views.content.ContentWindow;

import java.util.ArrayList;

/**
 * Created by WEIS on 16.04.2015.
 */
public class TableContent extends Content {


    public TableContent(CoPo p) {
        super(p);
    }

    @Override
    protected void onDrawInternal(Canvas canvas, Rect rect, ContentWindow window) {
        ArrayList<Rect> list = new ArrayList<>();
        list.add(rect);
        list.add(rect);
        onDrawInternal(canvas, list, window);
    }

    @Override
    protected void onDrawInternal(Canvas canvas, ArrayList<Rect> rects, ContentWindow window) {

        if(rects.size()>=2) {
            Rect r = combineRects(rects.get(0), rects.get(1));
            int w=10;
            Rect r2 = makeInnerRectWithTitle(r,w,rects.get(0).height());
            Path p = GeometricHelp.generateTrianglePath(r, w, w);

            canvas.drawPath(p, MenuConst.BACK_PAINTER_CONTENT_INNER2);
            canvas.drawPath(p, MenuConst.PLATE_STROKE_BACK_PAINTER);
            p = GeometricHelp.generateTrianglePath(r2, w, w);

            canvas.drawPath(p, MenuConst.BACK_PAINTER_CONTENT_INNER);
            canvas.drawPath(p, MenuConst.PLATE_STROKE_BACK_PAINTER);
        }

    }
}
