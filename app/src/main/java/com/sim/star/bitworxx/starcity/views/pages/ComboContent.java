package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.constants.CMB;
import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.geometric.GeometricHelp;

/**
 * Created by WEIS on 21.04.2015.
 */
public class ComboContent extends ButtonContent {

    private String Key;
    public ComboContent(CoPo p,String key, Runnable action) {
        super(p, action);
        Key=key;

    }


    @Override
    protected  void drawFilling(Canvas canvas,Rect r)
    {

        int w =6;
        boolean u = CMB.getCombo(Key);
        Path p = GeometricHelp.generateTrianglePath(r, w, w);
        if(u)
        {canvas.drawPath(p, MenuConst.PLATE_BACK_PAINTER);
            canvas.drawPath(p, MenuConst.BACK_PAINTER_CONTENT_INNER);

        }

        canvas.drawPath(p, MenuConst.BACK_PAINTER_CONTENT_INNER);
        canvas.drawPath(p, MenuConst.PLATE_STROKE_BACK_PAINTER);

        int h = r.height()/2;
        h-=4;
        Rect rB = new Rect(r.right-r.height(),r.top+h,r.right-h,r.bottom-h);
        if(u)
        {
            p = GeometricHelp.upTriangle(rB);
            Rect r2 = new Rect(r.left,r.bottom,r.right,r.bottom+r.height()*CMB.getSize(Key));
            Path p1 = GeometricHelp.generateTrianglePath(r2, w, w);

            canvas.drawPath(p1, MenuConst.BACK_PAINTER_WITH_SHADER);
            canvas.drawPath(p1, MenuConst.BACK_PAINTER_CONTENT_LIGHT_MAX);

            //canvas.drawPath(p1, MenuConst.PLATE_BACK_PAINTER);

            canvas.drawPath(p1, MenuConst.PLATE_STROKE_BACK_PAINTER);

        }
        else{        p = GeometricHelp.downTriangle(rB);    }
        canvas.drawPath(p, MenuConst.PLATE_BACK_PAINTER);

        canvas.drawPath(p, MenuConst.PLATE_STROKE_BACK_PAINTER);


    }
}
