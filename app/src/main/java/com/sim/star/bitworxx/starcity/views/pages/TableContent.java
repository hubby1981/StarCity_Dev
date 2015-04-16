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

        Rect r = new Rect(rects.get(0).left,rects.get(0).top,rects.get(1).right,rects.get(1).bottom);
        int plusW=10;
        int plusHT= rects.get(0).height();
        int plusHB=10;
        Rect r2 = new Rect(rects.get(0).left+plusW,rects.get(0).top+plusHT,rects.get(1).right-plusW,rects.get(1).bottom-plusHB);
        Path p = GeometricHelp.generateTrianglePath(r,10,10);

        canvas.drawPath(p, MenuConst.BACK_PAINTER_CONTENT);
        canvas.drawPath(p, MenuConst.PLATE_STROKE_BACK_PAINTER);
        p = GeometricHelp.generateTrianglePath(r2,10,10);

        canvas.drawPath(p, MenuConst.BACK_PAINTER_CONTENT_INNER);
        canvas.drawPath(p, MenuConst.PLATE_STROKE_BACK_PAINTER);


    }
}
