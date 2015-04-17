package com.sim.star.bitworxx.starcity.views.pages;

import com.sim.star.bitworxx.starcity.game.enums.TextSize;

import java.util.ArrayList;

/**
 * Created by WEIS on 16.04.2015.
 */
public class TextDescription extends BaseContentDescription<BaseContentDescription> {
    public String Text;
    public TextSize Size;

    public TextDescription(String text,TextSize size)
    {
        Text=text;
        Size=size;
    }

    @Override
    public boolean hasChilds() {
        return false;
    }

    @Override
    public ArrayList<BaseContentDescription> getChilds() {
        return null;
    }
}
