package com.sim.star.bitworxx.starcity.views.pattern;

import com.sim.star.bitworxx.starcity.geometric.CoPo;

/**
 * Created by WEIS on 27.04.2015.
 */
public abstract class CoPoPattern extends PatternBase {

    protected CoPo P;

    protected CoPoPattern(CoPo p)
    {
        super();
        P=p;
    }
}
