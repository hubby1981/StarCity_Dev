package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.constants.CHK;
import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.geometric.GeometricHelp;

/**
 * Created by WEIS on 21.04.2015.
 */
public class CheckboxContent extends ButtonContent {

    public String CheckedKey;


    public CheckboxContent(CoPo p,String checkedKey,Runnable action) {
        super(p,action);
        UseParentBounds=false;
        CheckedKey=checkedKey;
    }


    @Override
    protected  void drawFilling(Canvas canvas,Rect r)
    {
        int w =6;
        Rect r2=new Rect(r.left+4,r.top+4,(r.left+r.height()-4),r.bottom-4);
        Rect r4=new Rect(r.left+7,r.top+7,(r.left+r.height()-7),r.bottom-7);
        Rect r3 = new Rect(r2.left+w,r2.top+w,r2.right-w,r2.bottom-w);
        Path p = GeometricHelp.generateTrianglePath(r4, w, w);
        //canvas.drawPath(p, MenuConst.BACK_PAINTER_CONTENT_INNER);
        drawFillingInternal(canvas,r3);


        p = GeometricHelp.generateTrianglePath(r2, w, w);



        canvas.drawPath(p, MenuConst.BACK_PAINTER_CONTENT_INNER);
        canvas.drawPath(p, MenuConst.PLATE_STROKE_BACK_PAINTER);

    }

    protected void drawFillingInternal(Canvas canvas,Rect r3)
    {
        Path p2 = new Path();
        p2.moveTo(r3.left-2,r3.bottom-r3.height()/2);
        p2.lineTo(r3.left+r3.width()/2,r3.bottom);
        p2.lineTo(r3.right-1,r3.top-2);
        p2.lineTo(r3.centerX()-2,r3.centerY()+2);
        p2.lineTo(r3.left,r3.centerY()-2);
        if(CHK.ALL_CHECKED.containsKey(CheckedKey)&&CHK.ALL_CHECKED.get(CheckedKey)==true)
        {

            canvas.drawPath(p2,MenuConst.FORE_PAINTER_ICON);
        }
        else
        {
            canvas.drawPath(p2,MenuConst.BACK_PAINTER_CONTENT_INNER);


        }

    }
}
