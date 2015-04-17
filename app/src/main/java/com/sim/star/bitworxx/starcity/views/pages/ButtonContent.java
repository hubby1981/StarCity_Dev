package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.geometric.GeometricHelp;
import com.sim.star.bitworxx.starcity.views.content.ContentWindow;
import com.sim.star.bitworxx.starcity.views.touch.ActionContainer;

import java.util.ArrayList;

/**
 * Created by WEIS on 17.04.2015.
 */
public class ButtonContent extends Content {

    private Runnable Action;
    public ButtonContent(CoPo p,Runnable action) {
        super(p);
        Action=action;
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
            if(Action!=null)
                ActionContainer.addButton(r,Action);
            int w=10;
            Path p = GeometricHelp.generateTrianglePath(r, w, w);

            canvas.drawPath(p, MenuConst.BACK_PAINTER_CONTENT);
            canvas.drawPath(p, MenuConst.PLATE_STROKE_BACK_PAINTER);
        }
    }
}
