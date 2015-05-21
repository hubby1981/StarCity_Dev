package com.sim.star.bitworxx.starcity.views.pages;

import com.sim.star.bitworxx.starcity.constants.BTN;
import com.sim.star.bitworxx.starcity.constants.CHK;
import com.sim.star.bitworxx.starcity.constants.CMB;
import com.sim.star.bitworxx.starcity.constants.KEY;
import com.sim.star.bitworxx.starcity.constants.RBN;
import com.sim.star.bitworxx.starcity.constants.STAR;
import com.sim.star.bitworxx.starcity.constants.TXT;
import com.sim.star.bitworxx.starcity.game.enums.ContentType;
import com.sim.star.bitworxx.starcity.game.enums.TextSize;
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
                                                                                T==ContentType.COMBO?buildCombo():
                                                                                        T==ContentType.TEXT_CLICK?buildTextClick():
                                                                                                T==ContentType.TEXT_BOX?buildTextBox():
                                                                                                        T==ContentType.BUTTON_HIDDEN?buildButtonHidden():
                                                                                                                null;
    }


    private TextContent buildText()
    {
        TextDescription td = TXT.get(K);
        return new TextContent(P, td.Text,td.Size);
    }

    private TextClickContent buildTextClick()
    {
        TextDescription td = TXT.get(K);
        return new TextClickContent(P, td.Text,td.Size,CMB.getAction(K));
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

    private HiddenButtonContent buildButtonHidden()
    {
        ButtonDescription bd = BTN.get(K);
        HiddenButtonContent content= new HiddenButtonContent(P,bd.Action);
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

    private ComboContent buildCombo()
    {
        ComboDescription cd = CMB.get(K);

        ComboContent content= new ComboContent(P,K,cd.Action);
        if(cd.hasChilds())
        {
            int l = (P.R-P.L)/2;
            int t=(P.B-P.T)/2;
            for(TextDescription td : cd.getChilds())
                content.Childs.add(new TextContent(new CoPo(P.L+l,P.T+t),td.Text,td.Size));
        }
        return content;
    }

    private TextBoxContent buildTextBox()
    {
        TextBoxDescription cd = KEY.get(K);

        TextBoxContent content= new TextBoxContent(P,K,cd.Action);
        content.Childs.add(new TextContent(new CoPo(P.L+1,P.T),KEY.getText(K), TextSize.TEXT));
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
