package com.sim.star.bitworxx.starcity.views.anim;

import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.views.Mini;

/**
 * Created by WEIS on 13.04.2015.
 */
public abstract class Animateable {
    protected Mini Parent;
    public Rect DisplayRect;

    public Animateable(Mini parent) {
        Parent = parent;
    }

    public abstract void drawItems();

    protected boolean canDraw() {
        if (Parent != null && Parent.InboundRect != null) {
            DisplayRect = new Rect(Parent.InboundRect.left + Parent.translateMarginWidth() + MenuConst.FACTOR_TRIANGLE_OUT,
                    Parent.InboundRect.top + Parent.translateMarginHeight() + MenuConst.FACTOR_TRIANGLE_OUT,
                    Parent.InboundRect.right - +Parent.translateMarginWidth() - MenuConst.FACTOR_TRIANGLE_OUT,
                    Parent.InboundRect.bottom - Parent.translateMarginHeight() - MenuConst.FACTOR_TRIANGLE_OUT);
            return true;
        }
        return false;
    }
}
