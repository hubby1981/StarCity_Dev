package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.constants.CliprRects;
import com.sim.star.bitworxx.starcity.game.enums.TextSize;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.touch.ActionContainer;

/**
 * Created by WEIS on 20.05.2015.
 */
public class TextClickContent extends TextContent {

    private Runnable Action;
    public TextClickContent(CoPo p, String text, TextSize size,Runnable action) {
        super(p, text, size);
        Action=action;
    }

    @Override
    protected void doContentSupply(Rect r)
    {
        setClick(r);
    }

    protected void setClick(Rect r)
    {
        if(Action!=null)
        {
            int w = CliprRects.InnerRectMain.left- CliprRects.OuterRectContent.left;
            int h=CliprRects.InnerRectMain.top- CliprRects.OuterRectContent.top;
            Rect r2 = new Rect(r.left+ w,r.top+h,r.right+ w,r.bottom+h);
            ActionContainer.addButtonHidden(r2, Action);
        }
    }
}
