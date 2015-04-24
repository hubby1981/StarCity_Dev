package com.sim.star.bitworxx.starcity.views.anim;

import android.graphics.Path;

import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.highlight.HightlightMenu;
import com.sim.star.bitworxx.starcity.views.Mini;
import com.sim.star.bitworxx.starcity.views.icons.BankIcon;
import com.sim.star.bitworxx.starcity.views.icons.SkillIcon;

/**
 * Created by WEIS on 24.04.2015.
 */

public class SkillAnimation extends Animateable {
    public SkillAnimation(Mini parent) {

        super(parent);

    }

    public void drawItems() {
        if (canDraw()) {
            Path icon = new SkillIcon().getPath(DisplayRect);
            if (HightlightMenu.HIGH_SKILL) {
                Parent.getAsCanvas().drawPath(icon, MenuConst.PLATE_BACK_PAINTER);
            } else {
                Parent.getAsCanvas().drawPath(icon, MenuConst.FORE_PAINTER_ICON);
            }
        }
    }
}