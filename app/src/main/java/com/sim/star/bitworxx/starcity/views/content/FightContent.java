package com.sim.star.bitworxx.starcity.views.content;

import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.views.pages.PageBase;
import com.sim.star.bitworxx.starcity.views.pattern.PatternBase;
import com.sim.star.bitworxx.starcity.views.pattern.fight.FightMapPattern;

/**
 * Created by WEIS on 02.07.2015.
 */
public class FightContent extends  ContentWindow {
    public FightContent(Rect displayIn) {
        super(displayIn);
    }

    @Override
    public void setupPages() {

        Pages.clear();

        PageBase map = new PageBase(0,"FightMap");

        map.generate(new FightMapPattern("1"));

        Pages.add(map);
    }
}
