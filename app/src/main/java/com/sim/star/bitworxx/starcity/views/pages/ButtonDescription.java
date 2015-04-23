package com.sim.star.bitworxx.starcity.views.pages;

import com.sim.star.bitworxx.starcity.game.enums.TextSize;

import java.util.ArrayList;

/**
 * Created by WEIS on 17.04.2015.
 */
public class ButtonDescription extends BaseContentDescription<TextDescription> {

    public TextDescription Text;
    public Runnable Action;
    public boolean SearchText=true;
    public ButtonDescription(Runnable action)
    {
        this(new TextDescription("", TextSize.TEXT),action);
    }
    public ButtonDescription(Runnable action,boolean searchText)
    {
        this(new TextDescription("", TextSize.TEXT),action);
        SearchText=searchText;
    }
    public ButtonDescription(TextDescription text,Runnable action)
    {
        Text = text;
        Action = action;
    }

    @Override
    public boolean hasChilds() {
        return getChilds().size()>0;
    }

    @Override
    public ArrayList<TextDescription> getChilds() {
        ArrayList<TextDescription> result = new ArrayList<>();
        result.add(Text);
        return result;
    }
}
