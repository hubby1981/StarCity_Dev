package com.sim.star.bitworxx.starcity.views.pages;

import com.sim.star.bitworxx.starcity.constants.BTN;
import com.sim.star.bitworxx.starcity.constants.CHK;
import com.sim.star.bitworxx.starcity.constants.RBN;
import com.sim.star.bitworxx.starcity.constants.STAR;
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
                                        T==ContentType.CHECKBOX ?buildCheckbox():
                                                T==ContentType.RADIOBOX ?buildRadiobox():
                                                        T==ContentType.SYSTEM_OBJECT?buildSystemObject():
                                                                T==ContentType.PROGRESS_BAR?new ProgressBarContent(P):
                                                                        T==ContentType.PROGRESS_ARC?new ProgressArcContent(P):
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


    private CheckboxContent buildCheckbox()
    {
        CheckboxDescription cd = CHK.get(K);

        CheckboxContent content= new CheckboxContent(P,K,cd.Action);
        if(cd.hasChilds())
        {
            int l = (P.R-P.L)/2;
            int t=(P.B-P.T)/2;
            for(TextDescription td : cd.getChilds())
                content.Childs.add(new TextContent(new CoPo(P.L+l,P.T+t),td.Text,td.Size));
        }
        return content;
    }

    private SystemObjectContent buildSystemObject()
    {
        SystemObjectDescription cd = STAR.get(K);

        SystemObjectContent content= new SystemObjectContent(P,K,cd.Action);
        content.Size=cd.Size;
        content.Shader=cd.Shader;
        if(cd.hasChilds())
        {

        }
        return content;
    }

    private RadioboxContent buildRadiobox()
    {
        RadioboxDescription cd = RBN.get(K);

        RadioboxContent content= new RadioboxContent(P,K,cd.Action);
        if(cd.hasChilds())
        {
            int l = (P.R-P.L)/2;
            int t=(P.B-P.T)/2;
            for(TextDescription td : cd.getChilds())
                content.Childs.add(new TextContent(new CoPo(P.L+l,P.T+t),td.Text,td.Size));
        }
        return content;
    }
}
