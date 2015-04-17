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

        Contents.add(new ContentDescription(new CoPo(25,4,27,4),"btn-system-add", ContentType.BUTTON));
        Contents.add(new ContentDescription(new CoPo(25,6,27,6),"btn-system-add",ContentType.BUTTON));

        Contents.add(new ContentDescription(new CoPo(25,8,27,8),"btn-system-add",ContentType.BUTTON));

        Contents.add(new ContentDescription(new CoPo(25,10,27,10),"btn-system-add",ContentType.BUTTON));

        Contents.add(new ContentDescription(new CoPo(25,12,27,12),"btn-system-add",ContentType.BUTTON));



        Contents.add(new ContentDescription(new CoPo(29,4,31,4),"btn-system-add",ContentType.BUTTON));
        Contents.add(new ContentDescription(new CoPo(29,6,31,6),"btn-system-add",ContentType.BUTTON));

        Contents.add(new ContentDescription(new CoPo(29,8,31,8),"btn-system-add",ContentType.BUTTON));

        Contents.add(new ContentDescription(new CoPo(29,10,31,10),"btn-system-add",ContentType.BUTTON));

        Contents.add(new ContentDescription(new CoPo(29,12,31,12),"btn-system-add",ContentType.BUTTON));
    }
}
