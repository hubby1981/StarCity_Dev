package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.BitmapShader;

import com.sim.star.bitworxx.starcity.game.enums.TextSize;

import java.util.ArrayList;

/**
 * Created by WEIS on 22.04.2015.
 */

public class SystemObjectDescription extends BaseContentDescription<TextDescription> {

    public TextDescription Text;
    public Runnable Action;
    public boolean SearchText=true;

    public float Size=1;
    public BitmapShader Shader;
    public SystemObjectDescription(Runnable actrion)
    {
        this(new TextDescription("", TextSize.TEXT),actrion);
    }
    public SystemObjectDescription(Runnable actrion,float size,BitmapShader shader)
    {
        this(new TextDescription("", TextSize.TEXT),actrion);
        Size=size;
        Shader=shader;
    }
    public SystemObjectDescription(Runnable actrion,boolean searchText)
    {
        this(new TextDescription("", TextSize.TEXT),actrion);
        SearchText=searchText;
    }
    public SystemObjectDescription(TextDescription text,Runnable action)
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
