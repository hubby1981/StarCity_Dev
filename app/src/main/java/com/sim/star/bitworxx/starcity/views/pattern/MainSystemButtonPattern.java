package com.sim.star.bitworxx.starcity.views.pattern;

import com.sim.star.bitworxx.starcity.game.enums.ContentType;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.pages.ContentDescription;

/**
 * Created by WEIS on 17.04.2015.
 */
public class MainSystemButtonPattern extends PatternBase {

    public MainSystemButtonPattern()
    {
        StackingPattern st = new StackingPattern(2,0,2,2,new CoPo(25,4,30,15));
        Patterns.add(st);

        st.register(new ContentDescription("btn-system-add",ContentType.BUTTON));
        st.register(new ContentDescription("btn-system-add",ContentType.BUTTON));
        st.register(new ContentDescription("btn-system-add",ContentType.BUTTON));
        st.register(new ContentDescription("btn-system-add",ContentType.BUTTON));
        st.register(new ContentDescription("btn-system-add",ContentType.BUTTON));
        st.register(new ContentDescription("btn-system-add",ContentType.BUTTON));
        st.register(new ContentDescription("btn-system-add",ContentType.BUTTON));
        st.register(new ContentDescription("btn-system-add",ContentType.BUTTON));
        st.register(new ContentDescription("btn-system-add",ContentType.BUTTON));
        st.register(new ContentDescription("btn-system-add",ContentType.BUTTON));
    }
}
