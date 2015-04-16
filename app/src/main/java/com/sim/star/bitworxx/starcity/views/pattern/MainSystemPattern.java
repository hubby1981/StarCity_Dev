package com.sim.star.bitworxx.starcity.views.pattern;

import com.sim.star.bitworxx.starcity.game.enums.ContentType;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.pages.ContentDescription;

/**
 * Created by WEIS on 16.04.2015.
 */
public class MainSystemPattern extends PatternBase {

    public MainSystemPattern()
    {
        Contents.add(new ContentDescription(new CoPo(0,0),"header-systems", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(28,0),"page", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(30,0),"2", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(31,0),"2", ContentType.TEXT));
    }
}
