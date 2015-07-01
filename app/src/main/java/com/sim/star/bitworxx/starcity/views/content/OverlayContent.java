package com.sim.star.bitworxx.starcity.views.content;

import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.views.pages.PageBase;
import com.sim.star.bitworxx.starcity.views.pattern.MainMenuPattern;

/**
 * Created by WEIS on 01.07.2015.
 */
public class OverlayContent extends ContentWindow {
    public OverlayContent(Rect displayIn) {
        super(displayIn);
        super.PaintOnlyContent=true;
    }

    @Override
    public void setupPages() {
        Pages.clear();
        PageBase main = new PageBase(0,"Main Menu");

        main.generate(new MainMenuPattern());

        Pages.add(main);
    }
}
