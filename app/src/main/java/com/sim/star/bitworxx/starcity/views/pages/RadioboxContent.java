package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.constants.RBN;
import com.sim.star.bitworxx.starcity.geometric.CoPo;

/**
 * Created by WEIS on 21.04.2015.
 */
public class RadioboxContent extends CheckboxContent {
    public RadioboxContent(CoPo p, String checkedKey, Runnable action) {
        super(p, checkedKey, action);
    }


    @Override
    protected void drawFillingInternal(Canvas canvas,Rect r3)
    {
        r3=new Rect(r3.left+r3.width()/4,r3.top+r3.height()/4,r3.right-r3.width()/4,r3.bottom-r3.height()/4);

        if(RBN.ALL_CHECKED.containsKey(CheckedKey)&& RBN.ALL_CHECKED.get(CheckedKey)==true)
        {
            canvas.drawArc(new RectF((float)r3.left,(float)r3.top,(float)r3.right,(float)r3.bottom),0,360,true,MenuConst.FORE_PAINTER_ICON);
        }
        else
        {
            canvas.drawArc(new RectF((float)r3.left,(float)r3.top,(float)r3.right,(float)r3.bottom),0,360,true,MenuConst.BACK_PAINTER_CONTENT_INNER);



        }

    }
}
