package com.sim.star.bitworxx.starcity.views.pattern;

import com.sim.star.bitworxx.starcity.game.enums.ContentType;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.pages.ContentDescription;

/**
 * Created by WEIS on 16.04.2015.
 */
public class MainSystemPattern extends PatternBase {

    public MainSystemPattern(String pageCount)
    {
        Contents.add(new ContentDescription(new CoPo(0,0),"header-systems", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(28,0),"page", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(30,0),"2", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(31,0),pageCount, ContentType.TEXT));

        Patterns.add(new SystemTablePattern());

        Patterns.add(new MainSystemButtonPattern());


        Contents.add(new ContentDescription(new CoPo(1,15,3,15),"PREV",ContentType.BUTTON));
        Contents.add(new ContentDescription(new CoPo(10,15,12,15),"page",ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(13,15,12,15),"3",ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(20,15,22,15),"NEXT",ContentType.BUTTON));

        StackingPattern st = new StackingPattern(3,0,8,1,new CoPo(1,1,30,4));

        st.register(new ContentDescription("Explore",ContentType.BUTTON));
        st.register(new ContentDescription("Build",ContentType.BUTTON));
        st.register(new ContentDescription("Settle",ContentType.BUTTON));
        st.register(new ContentDescription("Spy",ContentType.BUTTON));

        Patterns.add(st);
    }
}
