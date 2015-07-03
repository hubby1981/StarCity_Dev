package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.constants.MenuBitmaps;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.touch.ActionContainer;

/**
 * Created by WEIS on 21.05.2015.
 */
public class HiddenButtonContent extends ButtonContent {
    public HiddenButtonContent(CoPo p, Runnable action) {
        super(p, action);
    }

    @Override
    protected void setHandler(Rect rect,Runnable action)
    {
        ActionContainer.addButtonHidden(rect, Action,Token);
    }
}
