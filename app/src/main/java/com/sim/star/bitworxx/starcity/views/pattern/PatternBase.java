package com.sim.star.bitworxx.starcity.views.pattern;

import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.pages.Content;
import com.sim.star.bitworxx.starcity.views.pages.ContentDescription;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by WEIS on 16.04.2015.
 */
public abstract class PatternBase {

    public ArrayList<ContentDescription> Contents;

    public PatternBase()
    {
        Contents=new ArrayList<ContentDescription>();
    }

    public ArrayList<Content> build()
    {
        ArrayList<Content> contents = new ArrayList<Content>();
        if(Contents!=null){
        for(ContentDescription cd :Contents)
        {
            Content c = cd.build();
            if(c!=null)
                contents.add(c);
        }}
        return contents;
    }
}
