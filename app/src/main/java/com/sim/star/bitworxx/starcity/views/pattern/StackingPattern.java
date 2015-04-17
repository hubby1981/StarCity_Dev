package com.sim.star.bitworxx.starcity.views.pattern;

import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.pages.ContentDescription;

/**
 * Created by WEIS on 17.04.2015.
 */
public class StackingPattern extends PatternBase {

    private CoPo P;
    private int W;
    private int H;
    private int M;
    private int R;
    private int MM;
    private int X=0;
    private int Y=0;

    private boolean MORE=true;

    public StackingPattern(int w,int h,int m,int mm,CoPo p)
    {
        super();
        P=p;
        X=P.L;
        Y=P.T;
        W=w;
        H=h;
        M=m;
        MM=mm;
        R=p.R;
    }

    public void register(ContentDescription cd)
    {
        if(MORE) {
            cd.P = new CoPo(X, Y, X + W, Y + H);
            Contents.add(cd);
            if (X + (W + M) >= R) {
                X = P.L;
                Y += H + MM;
                if (Y + H > P.B) MORE = false;
            } else {
                X += W + M;
            }
        }
    }
}
