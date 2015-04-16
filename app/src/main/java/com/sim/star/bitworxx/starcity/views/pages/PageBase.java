package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.Canvas;

import com.sim.star.bitworxx.starcity.views.pattern.PatternBase;

import java.util.ArrayList;

/**
 * Created by WEIS on 16.04.2015.
 */
public class PageBase {

    public String Name;
    public long Id;

    ArrayList<Content> Contents;

    public PageBase(long id)
    {
        this(id,"none");
    }

    public PageBase(long id,String name)
    {
        Name=name;
        Id=id;
        Contents= new ArrayList<Content>();
    }

    public void RegisterContent(Content content)
    {
        Contents.add(content);
    }

    public ArrayList<Content> drawContents()
    {
        return Contents;
    }

    public void generate(PatternBase pattern)
    {
        Contents = pattern.build();
    }
}
