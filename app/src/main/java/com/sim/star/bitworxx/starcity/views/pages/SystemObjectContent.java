package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.constants.STAR;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.geometric.GeometricHelp;
import com.sim.star.bitworxx.starcity.views.content.ContentWindow;

import java.util.ArrayList;

/**
 * Created by WEIS on 22.04.2015.
 */
public class SystemObjectContent extends ButtonContent {

    public String CheckedKey;
    public SystemObjectContent(CoPo p,String checkedKey,Runnable action) {
        super(p,action);
        CheckedKey=checkedKey;
    }

    @Override
    protected void onDrawInternal(Canvas canvas, ArrayList<Rect> rects, ContentWindow window) {
        if(rects.size()>=2) {
            Rect r = combineRects(rects.get(0), rects.get(1));
            int w=r.width()/10;
            int size = 2;
            w=w*size;

            RectF rf = new RectF((float)r.centerX()-w,(float)r.centerY()-w,(float)r.centerX()+w,(float)r.centerY()+w);

            if(STAR.ALL_CHECKED.containsKey(CheckedKey))
                canvas.drawArc(rf,(float)0,(float)360,true,MenuConst.PLATE_BACK_PAINTER);
            else
                canvas.drawArc(rf,(float)0,(float)360,true,MenuConst.FORE_PAINTER_ICON);
        }
    }
}
