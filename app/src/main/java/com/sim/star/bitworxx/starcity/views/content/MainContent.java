package com.sim.star.bitworxx.starcity.views.content;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.constants.ContentFont;
import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.game.enums.TextSize;
import com.sim.star.bitworxx.starcity.views.pages.PageBase;
import com.sim.star.bitworxx.starcity.views.pages.TextContent;
import com.sim.star.bitworxx.starcity.views.pattern.MainIndexPattern;
import com.sim.star.bitworxx.starcity.views.pattern.MainSystemPattern;
import com.sim.star.bitworxx.starcity.views.pattern.SystemViewPattern;

import java.util.ArrayList;

/**
 * Created by WEIS on 15.04.2015.
 */
public class MainContent extends ContentWindow {

    public MainContent(Rect displayIn) {
        super(displayIn);
    }
    public static String PageCount="3";
    @Override
    public void setupPages() {

        Pages.clear();
        PageBase indexPage = new PageBase(0,"MainIndex");
        PageBase systemPage = new PageBase(1,"MainSystems");
        PageBase systemView = new PageBase(2,"SystemView");

        indexPage.generate(new MainIndexPattern(PageCount));
        systemPage.generate(new MainSystemPattern(PageCount));
        systemView.generate(new SystemViewPattern(PageCount));

        Pages.add(indexPage);
        Pages.add(systemPage);
        Pages.add(systemView);

    }



}
