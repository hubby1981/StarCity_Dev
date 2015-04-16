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

import java.util.ArrayList;

/**
 * Created by WEIS on 15.04.2015.
 */
public class MainContent extends ContentWindow {

    public MainContent(Rect displayIn) {
        super(displayIn);
    }

    @Override
    protected void setupPages() {


        PageBase indexPage = new PageBase(0,"MainIndex");

        indexPage.RegisterContent(new TextContent(new Point(0,2),"Main Menu Overview M.A.P. System", TextSize.HEADER));
        indexPage.RegisterContent(new TextContent(new Point(28,0),"Page", TextSize.TEXT));

        indexPage.RegisterContent(new TextContent(new Point(30,0),"1", TextSize.TEXT));
        indexPage.RegisterContent(new TextContent(new Point(31,0)," 2", TextSize.TEXT));
        PageBase systemPage = new PageBase(1,"MainSystems");
        systemPage.RegisterContent(new TextContent(new Point(0,4),"Systems", TextSize.HEADER));

        systemPage.RegisterContent(new TextContent(new Point(6,4),"Systems", TextSize.SUB_HEADER));
        systemPage.RegisterContent(new TextContent(new Point(12,4),"Dark Matter Reactor", TextSize.SUB_HEADER));
        systemPage.RegisterContent(new TextContent(new Point(12,5),"This reactor transforms the energy from the universe.", TextSize.TEXT));
        systemPage.RegisterContent(new TextContent(new Point(12,6),"Explode Rate 34 Percent", TextSize.TEXT));

        systemPage.RegisterContent(new TextContent(new Point(28,0),"Page", TextSize.TEXT));

        systemPage.RegisterContent(new TextContent(new Point(30,0),"2", TextSize.TEXT));
        systemPage.RegisterContent(new TextContent(new Point(31,0)," 2", TextSize.TEXT));

        Pages.add(indexPage);
        Pages.add(systemPage);
    }



}
