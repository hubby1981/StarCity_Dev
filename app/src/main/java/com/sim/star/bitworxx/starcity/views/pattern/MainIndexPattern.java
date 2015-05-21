package com.sim.star.bitworxx.starcity.views.pattern;

import com.sim.star.bitworxx.starcity.constants.MenuBitmaps;
import com.sim.star.bitworxx.starcity.game.enums.ContentType;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.pages.ContentDescription;

/**
 * Created by WEIS on 16.04.2015.
 */
public class MainIndexPattern extends PatternBase {

    public MainIndexPattern(String pageCount)
    {
        super();
        Contents.add(new ContentDescription(new CoPo(0, 0), "header-main", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(28,0),"page", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(30,0),"1", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(31,0), pageCount, ContentType.TEXT));

        Contents.add(new ContentDescription(new CoPo(0,3),"header-main-functions", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(1,4),"header-main-functions_desc", ContentType.TEXT));

        Contents.add(new ContentDescription(new CoPo(1,7,4,7),"use sublight", ContentType.CHECKBOX));
        Contents.add(new ContentDescription(new CoPo(1,8,4,8),"use linear", ContentType.CHECKBOX));
        Contents.add(new ContentDescription(new CoPo(1,9,4,9),"use commander", ContentType.CHECKBOX));


/*
        Contents.add(new ContentDescription(new CoPo(10, 8, 20, 13), "", ContentType.TABLE));
        Contents.add(new ContentDescription(new CoPo(11, 8), "choose pattern", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(10,9,13,9),"rbn-use-action-1", ContentType.RADIOBOX));
        Contents.add(new ContentDescription(new CoPo(15,9,18,9),"rbn-use-action-2", ContentType.RADIOBOX));
        Contents.add(new ContentDescription(new CoPo(10,10,13,10),"rbn-use-action-3", ContentType.RADIOBOX));
        Contents.add(new ContentDescription(new CoPo(15,10,18,10),"rbn-use-action-4", ContentType.RADIOBOX));
        Contents.add(new ContentDescription(new CoPo(10,11,13,11),"rbn-use-action-5", ContentType.RADIOBOX));
        Contents.add(new ContentDescription(new CoPo(15,11,18,11),"rbn-use-action-6", ContentType.RADIOBOX));
        Contents.add(new ContentDescription(new CoPo(10,12,13,12),"rbn-use-action-7", ContentType.RADIOBOX));
        Contents.add(new ContentDescription(new CoPo(15,12,18,12),"rbn-use-action-8", ContentType.RADIOBOX));
*/

        Contents.add(new ContentDescription(new CoPo(1,11,6,11),"",ContentType.PROGRESS_BAR));
        Contents.add(new ContentDescription(new CoPo(1,13,3,15),"",ContentType.PROGRESS_ARC));


        Patterns.add(new MainSystemButtonPattern());
        Patterns.add(new ColorComboPattern(new CoPo(1,6,7,6)));
        Patterns.add(new TextBoxPattern(new CoPo(10, 6, 19, 6),"index-mail"));
        Patterns.add(new TextBoxPattern(new CoPo(10, 3, 19, 3),"index-name"));


    }
}
