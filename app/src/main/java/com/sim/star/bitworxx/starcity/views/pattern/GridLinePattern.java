package com.sim.star.bitworxx.starcity.views.pattern;

import com.sim.star.bitworxx.starcity.game.enums.ContentType;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.pages.ContentDescription;

/**
 * Created by WEIS on 27.04.2015.
 */
public class GridLinePattern extends CoPoPattern {


    protected GridLinePattern(int x,int y,CoPo p) {
        super(p);


        int w = (p.R-p.L)/x;
        int h = (p.B-p.T)/y;

        for(int iw=1;iw<=w;iw++)
        {

            Contents.add(new ContentDescription(new CoPo(P.L+(x*iw),p.T, P.L+(x*iw),p.B), "", ContentType.LINE));


        }

        for(int iy=1;iy<=h;iy++)
        {
            Contents.add(new ContentDescription(new CoPo(P.L,P.T+(y*iy), P.R, P.T+(y*iy)), "", ContentType.LINE));
        }
    }



}
