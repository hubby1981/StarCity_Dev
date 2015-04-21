package com.sim.star.bitworxx.starcity.views.pages;

import com.sim.star.bitworxx.starcity.game.enums.TextSize;

import java.util.ArrayList;

/**
 * Created by WEIS on 21.04.2015.
 */
public class CheckboxDescription extends BaseContentDescription<TextDescription> {

    public TextDescription Text;
    public Runnable Action;
    public boolean SearchText=true;
    public CheckboxDescription(Runnable actrion)
    {
        this(new TextDescription("", TextSize.TEXT),actrion);
    }
    public CheckboxDescription(Runnable actrion,boolean searchText)
    {
        this(new TextDescription("", TextSize.TEXT),actrion);
        SearchText=searchText;
    }
    public CheckboxDescription(TextDescription text,Runnable action)
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