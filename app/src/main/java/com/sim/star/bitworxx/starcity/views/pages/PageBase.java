package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.Canvas;

import com.sim.star.bitworxx.starcity.views.pattern.PatternBase;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by WEIS on 16.04.2015.
 */
public class PageBase {

    public String Name;
    public long Id;
    public String UId;
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
        UId=UUID.randomUUID().toString();
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
