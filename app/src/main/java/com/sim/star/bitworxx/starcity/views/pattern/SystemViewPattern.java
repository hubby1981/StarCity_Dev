package com.sim.star.bitworxx.starcity.views.pattern;

import com.sim.star.bitworxx.starcity.game.enums.ContentType;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.pages.ContentDescription;

/**
 * Created by WEIS on 22.04.2015.
 */
public class SystemViewPattern extends PatternBase {
    public SystemViewPattern(String pageCount) {
        Contents.add(new ContentDescription(new CoPo(0, 0), "header-system", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(5, 0), "Pytico II", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(28, 0), "page", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(30, 0), "3", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(31, 0), pageCount, ContentType.TEXT));

        Contents.add(new ContentDescription(new CoPo(0, 2, 23, 14), "", ContentType.TABLE));

        Contents.add(new ContentDescription(new CoPo(25, 2, 31, 14), "", ContentType.TABLE));


        Contents.add(new ContentDescription(new CoPo(0, 5, 23, 5), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(0, 7, 23, 7), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(0, 9, 23, 9), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(0, 11, 23, 11), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(0, 13, 23, 13), "", ContentType.LINE));

        Contents.add(new ContentDescription(new CoPo(2, 3, 2, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(4, 3, 4, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(6, 3, 6, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(8, 3, 8, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(10, 3, 10, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(12, 3, 12, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(14, 3, 14, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(16, 3, 16, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(18, 3, 18, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(20, 3, 20, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(22, 3, 22, 14), "", ContentType.LINE));

        Contents.add(new ContentDescription(new CoPo(1, 2), "Solar System Objects", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(26, 2), "DATA", ContentType.TEXT));

        Contents.add(new ContentDescription(new CoPo(1, 3), "DEATH", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(9, 3), "LIVING", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(21, 3), "DEATH", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(1, 4), "A", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(3, 4), "B", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(5, 4), "C", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(7, 4), "D", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(9, 4), "E", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(11, 4), "F", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(13, 4), "G", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(15, 4), "H", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(17, 4), "I", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(19, 4), "J", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(21, 4), "K", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(23, 4), "L", ContentType.TEXT));

        Contents.add(new ContentDescription(new CoPo(0,9,1,10),"",ContentType.SYSTEM_OBJECT));

    }
}
