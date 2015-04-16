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

        Contents.add(new ContentDescription(new CoPo(0,4,23,15),"",ContentType.TABLE));
        Contents.add(new ContentDescription(new CoPo(1,4),"header-systems-table", ContentType.TEXT));

        Contents.add(new ContentDescription(new CoPo(1,5),"header-systems-table_name", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(11,5),"header-systems-table_sector", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(19,5),"header-systems-table_status", ContentType.TEXT));

        Contents.add(new ContentDescription(new CoPo(1,7),"Pytico I", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(11,7),"45.10.99.200", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(19,7),"settle", ContentType.TEXT));

        Contents.add(new ContentDescription(new CoPo(1,8),"Pytico II", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(11,8),"45.10.0.200", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(19,8),"wait", ContentType.TEXT));

        Contents.add(new ContentDescription(new CoPo(1,9),"Sambut", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(11,9),"45.123.99.200", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(19,9),"wait", ContentType.TEXT));

        Contents.add(new ContentDescription(new CoPo(1,10),"Taba", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(11,10),"45.1.99.200", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(19,10),"explore", ContentType.TEXT));
    }
}
