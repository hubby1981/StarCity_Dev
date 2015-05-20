package com.sim.star.bitworxx.starcity.views.pattern;

import com.sim.star.bitworxx.starcity.constants.CMB;
import com.sim.star.bitworxx.starcity.game.enums.ContentType;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.pages.Content;
import com.sim.star.bitworxx.starcity.views.pages.ContentDescription;
import com.sim.star.bitworxx.starcity.views.pages.TextClickContent;

import java.util.ArrayList;

/**
 * Created by WEIS on 20.05.2015.
 */
public class ColorComboPattern extends CoPoPattern {

    protected ColorComboPattern(CoPo p) {
        super(p);


        Contents.add(new ContentDescription(p, "cmb-colors", ContentType.COMBO));



    }

    @Override
    public ArrayList<ContentDescription> getHidden()
    {
        ArrayList<ContentDescription> result=new ArrayList<>();
        CoPo p = P;
        boolean u = CMB.getCombo("cmb-colors");
        if(u)
        {
            result.add(new ContentDescription(new CoPo(p.L+1, p.B+1,p.R,p.B+1), "cmb-colors-1", ContentType.TEXT_CLICK));
            result.add(new ContentDescription(new CoPo(p.L+1, p.B+2,p.R,p.B+2), "cmb-colors-2", ContentType.TEXT_CLICK));
            result.add(new ContentDescription(new CoPo(p.L+1, p.B+3,p.R,p.B+3), "cmb-colors-3", ContentType.TEXT_CLICK));
            result.add(new ContentDescription(new CoPo(p.L+1, p.B+4,p.R,p.B+4), "cmb-colors-4", ContentType.TEXT_CLICK));
            result.add(new ContentDescription(new CoPo(p.L+1, p.B+5,p.R,p.B+5), "cmb-colors-5", ContentType.TEXT_CLICK));
            result.add(new ContentDescription(new CoPo(p.L+1, p.B+6,p.R,p.B+6), "cmb-colors-6", ContentType.TEXT_CLICK));
            result.add(new ContentDescription(new CoPo(p.L+1, p.B+7,p.R,p.B+7), "cmb-colors-7", ContentType.TEXT_CLICK));
            result.add(new ContentDescription(new CoPo(p.L+1, p.B+8,p.R,p.B+8), "cmb-colors-8", ContentType.TEXT_CLICK));

        }
        return result;
    }
}
