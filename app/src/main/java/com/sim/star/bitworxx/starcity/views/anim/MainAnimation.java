package com.sim.star.bitworxx.starcity.views.anim;

import android.graphics.Path;

import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.highlight.HightlightMenu;
import com.sim.star.bitworxx.starcity.views.Mini;
import com.sim.star.bitworxx.starcity.views.icons.MainIcon;

/**
 * Created by WEIS on 13.04.2015.
 */
public class MainAnimation extends Animateable {
    public MainAnimation(Mini parent) {

        super(parent);

    }

    public void drawItems() {
        if (canDraw()) {
            Path icon = new MainIcon().getPath(DisplayRect);
            if (HightlightMenu.HIGH_MAIN_MENU) {
                Parent.getAsCanvas().drawPath(icon, MenuConst.PLATE_BACK_PAINTER);
            } else {
                Parent.getAsCanvas().drawPath(icon, MenuConst.FORE_PAINTER_ICON);
            }
        }
    }
}
