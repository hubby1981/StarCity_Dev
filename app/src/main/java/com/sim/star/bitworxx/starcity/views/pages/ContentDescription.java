package com.sim.star.bitworxx.starcity.views.pages;

import com.sim.star.bitworxx.starcity.constants.TXT;
import com.sim.star.bitworxx.starcity.game.enums.ContentType;
import com.sim.star.bitworxx.starcity.geometric.CoPo;

/**
 * Created by WEIS on 16.04.2015.
 */
public class ContentDescription {

    public CoPo P;
    public String K;
    public ContentType T;


    public ContentDescription(CoPo p,String k,ContentType t)
    {
        P=p;
        K=k;
        T=t;
    }

    public Content build()
    {
            if(P!=null&&K!=null&&T!=null)
                return buildInternal();
            return null;
    }

    private Content buildInternal()
    {
        return T==ContentType.TEXT ? buildText():null;
    }


    private TextContent buildText()
    {
        TextDescription td = TXT.get(K);
        return new TextContent(P, td.Text,td.Size);
    }

}
