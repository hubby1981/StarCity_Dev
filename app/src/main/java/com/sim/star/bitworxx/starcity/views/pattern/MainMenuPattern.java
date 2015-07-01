package com.sim.star.bitworxx.starcity.views.pattern;

import com.sim.star.bitworxx.starcity.game.enums.ContentType;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.pages.ContentDescription;

/**
 * Created by WEIS on 01.07.2015.
 */
public class MainMenuPattern extends PatternBase {


    public MainMenuPattern()
    {
        Contents.add(new ContentDescription(new CoPo(13,8,18,8),"btn-main-play", ContentType.BUTTON));
        Contents.add(new ContentDescription(new CoPo(13,10,18,10),"btn-main-new", ContentType.BUTTON));
        Contents.add(new ContentDescription(new CoPo(13,14,18,14),"btn-main-options", ContentType.BUTTON));


    }
}
