package com.sim.star.bitworxx.starcity.views.pattern;

import com.sim.star.bitworxx.starcity.game.enums.ContentType;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.pages.ContentDescription;

/**
 * Created by WEIS on 17.04.2015.
 */
public class SystemTablePattern extends PatternBase {

    public SystemTablePattern() {
        Contents.add(new ContentDescription(new CoPo(0, 4, 23, 14), "", ContentType.TABLE));
        Contents.add(new ContentDescription(new CoPo(1, 4), "header-systems-table", ContentType.TEXT));

        Contents.add(new ContentDescription(new CoPo(1, 5), "header-systems-table_name", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(11, 5), "header-systems-table_sector", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(19, 5), "header-systems-table_status", ContentType.TEXT));

        Contents.add(new ContentDescription(new CoPo(1, 7), "Pytico I", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(11, 7,16,7), "45.10.99.200", ContentType.BUTTON));
        Contents.add(new ContentDescription(new CoPo(19, 7), "settle", ContentType.TEXT));

        Contents.add(new ContentDescription(new CoPo(1, 8), "Pytico II", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(11, 8,16,8), "45.10.0.200", ContentType.BUTTON));
        Contents.add(new ContentDescription(new CoPo(19, 8), "wait", ContentType.TEXT));

        Contents.add(new ContentDescription(new CoPo(1, 9), "Sambut", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(11, 9,16,9), "45.123.99.200", ContentType.BUTTON));
        Contents.add(new ContentDescription(new CoPo(19, 9), "wait", ContentType.TEXT));

        Contents.add(new ContentDescription(new CoPo(1, 10), "Taba", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(11, 10,16,10), "45.1.99.200", ContentType.BUTTON));
        Contents.add(new ContentDescription(new CoPo(19, 10), "explore", ContentType.TEXT));


        Contents.add(new ContentDescription(new CoPo(10, 5, 10, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(18, 5, 18, 14), "", ContentType.LINE));

        Contents.add(new ContentDescription(new CoPo(0, 6, 23, 6), "", ContentType.LINE));
    }
}
