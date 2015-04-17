package com.sim.star.bitworxx.starcity.views.pages;

import com.sim.star.bitworxx.starcity.constants.BTN;
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

    public ContentDescription(String k,ContentType t)
    {
        P=new CoPo(0,0);
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
        return T==ContentType.TEXT ? buildText():
                T==ContentType.TABLE?new TableContent(P):
                        T==ContentType.BUTTON?buildButton():
                                T==ContentType.LINE?new LineContent(P):
                                        null;
    }


    private TextContent buildText()
    {
        TextDescription td = TXT.get(K);
        return new TextContent(P, td.Text,td.Size);
    }

    private ButtonContent buildButton()
    {
        ButtonDescription bd = BTN.get(K);
        ButtonContent content= new ButtonContent(P,bd.Action);
        if(bd.hasChilds())
        {
            int l = (P.R-P.L)/2;
            int t=(P.B-P.T)/2;
            for(TextDescription td : bd.getChilds())
                content.Childs.add(new TextContent(new CoPo(P.L+l,P.T+t),td.Text,td.Size));
        }
        return content;
    }


}
