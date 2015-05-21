package com.sim.star.bitworxx.starcity.views.pattern;

import com.sim.star.bitworxx.starcity.game.enums.ContentType;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.pages.Content;
import com.sim.star.bitworxx.starcity.views.pages.ContentDescription;

/**
 * Created by WEIS on 21.05.2015.
 */
public class TextBoxPattern extends CoPoPattern {

    private String Key;
    protected TextBoxPattern(CoPo p,String key) {
        super(p);
        Key=key;

        Contents.add(new ContentDescription(p,key, ContentType.TEXT_BOX));
        Patterns.add(new KeyBoardPattern(p,key));
    }
}
