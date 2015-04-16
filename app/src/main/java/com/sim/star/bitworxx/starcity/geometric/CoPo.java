package com.sim.star.bitworxx.starcity.geometric;

/**
 * Created by WEIS on 16.04.2015.
 */
public class CoPo {

    public int L=0;
    public int T=0;
    public int R=0;
    public int B=0;

    public CoPo(int l,int t)
    {
        this(l,t,l,t);
    }

    public CoPo(int l,int t,int r, int b)
    {
        L=l;
        T=t;
        R=r;
        B=b;
    }

    public boolean isSingle()
    {
        return L==R&&T==B;
    }
}
