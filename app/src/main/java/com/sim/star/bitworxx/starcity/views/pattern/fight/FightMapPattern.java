package com.sim.star.bitworxx.starcity.views.pattern.fight;

import com.sim.star.bitworxx.starcity.game.enums.ContentType;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.pages.ContentDescription;
import com.sim.star.bitworxx.starcity.views.pattern.GridLinePattern;
import com.sim.star.bitworxx.starcity.views.pattern.PageCountPatternBase;
import com.sim.star.bitworxx.starcity.views.pattern.PatternBase;

import java.util.regex.Pattern;

/**
 * Created by WEIS on 02.07.2015.
 */
public class FightMapPattern extends PageCountPatternBase {

    public FightMapPattern(String pageCount) {
        super(pageCount);

        Contents.add(new ContentDescription(new CoPo(0, 0), "header-fight_map", ContentType.TEXT));

        Contents.add(new ContentDescription(new CoPo(28, 0), "page", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(30, 0), "1", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(31, 0), PageCount, ContentType.TEXT));


        Contents.add(new ContentDescription(new CoPo(0, 2, 15, 14), "", ContentType.TABLE));
        Patterns.add(new GridLinePattern(1,1,new CoPo(0,3,15,14)));

        Contents.add(new ContentDescription(new CoPo(17, 2, 23, 14), "", ContentType.TABLE));

        Contents.add(new ContentDescription(new CoPo(17, 9, 23, 14), "", ContentType.TABLE));
        Contents.add(new ContentDescription(new CoPo(25, 9, 31, 14), "", ContentType.TABLE));
    }
}
